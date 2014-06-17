/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecaresoft.taller1;

import com.ecaresoft.taller1.sih.modelo.actores.Medico;
import com.ecaresoft.taller1.sih.modelo.actores.Paciente;
import com.ecaresoft.taller1.sih.modelo.entidades.Cirugia;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * Flujo principal de proceso.
 * @author mrojas
 */
public class Proceso {

    /**
     * Todo programa Java tiene este punto de entrada.
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Proceso.class.getName());
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        
        // manejo de excepciones en Java, se utiliza el bloque try ... catch
        try {
            
            fileHandler = new FileHandler("HIS.log");
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
            
            // creamos un medico
            Medico medico = new Medico();
            medico.setNombre1("Miguel");
            medico.setNombre2("Angel");
            medico.setApellido1("Rojas");
            medico.setApellido2("Aquino");
            
            // lo almacenamos
            medico.guardar();
            // mostramos en la consola el identificador asignado al medico
            logger.warning("Id " + medico.getId() + " - " + medico.getNombreCompleto());
            
            // creamos otro medico
            medico = new Medico();
            medico.setNombre1("Francisco");
            medico.setNombre2("Omar");
            medico.setApellido1("De la Rosa");
            medico.setApellido2("Palacios");
            
            // lo almacenamos
            medico.guardar();
            // mostramos en la consola el identificador asignado al medico
            logger.warning("Id " + medico.getId() + " - " + medico.getNombreCompleto());
            
            // creamos un paciente
            Paciente paciente = new Paciente();
            paciente.setNombre1("Luis");
            paciente.setApellido1("Lopez");
            paciente.setApellido2("Hernandez");
//            paciente.setFinado(true);
            
            // lo almacenamos
            paciente.guardar();
            // mostramos en la consola el identificador asignado al paciente
            logger.warning("Id " + paciente.getId() + " - " + paciente.getNombreCompleto());
            
            Medico cirujano = null;
            Paciente paciente2 = null;
            
            // programamos una cirugia
            Cirugia cirugia = new Cirugia(medico, paciente, null);
            logger.warning(cirugia.toString());
            
            
            // obtenemos las propiedades del objeto y sus valores, utilizando la introspeccion
            // utilizando la biblioteca commons bean-utils
            Map<String, Object> propiedades = 
                    PropertyUtils.describe(paciente);
            
            // obtenemos los nombres de las propiedades
            Set<String> llaves = propiedades.keySet();
            
            // mostramos en la consola el nombre de las propiedades
            for(String llave : llaves) {
                logger.warning("Propiedad : " + llave);
//                System.out.println("Propiedad = " + llave);
            }
            
        } catch (IllegalAccessException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
    
}
