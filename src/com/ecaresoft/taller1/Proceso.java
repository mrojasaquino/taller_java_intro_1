/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecaresoft.taller1;

import com.ecaresoft.taller1.sih.modelo.actores.Medico;
import com.ecaresoft.taller1.sih.modelo.actores.Paciente;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        // manejo de excepciones en Java, se utiliza el bloque try ... catch
        try {
            // creamos un medico
            Medico medico = new Medico();
            medico.setNombre1("Miguel");
            medico.setNombre2("Angel");
            medico.setApellido1("Rojas");
            medico.setApellido2("Aquino");
            
            // lo almacenamos
            medico.guardar();
            // mostramos en la consola el identificador asignado al medico
            System.out.println("Id " + medico.getId() + " - " + medico.getNombreCompleto());
            
            // creamos otro medico
            medico = new Medico();
            medico.setNombre1("Francisco");
            medico.setNombre2("Omar");
            medico.setApellido1("De la Rosa");
            medico.setApellido2("Palacios");
            
            // lo almacenamos
            medico.guardar();
            // mostramos en la consola el identificador asignado al medico
            System.out.println("Id " + medico.getId() + " - " + medico.getNombreCompleto());
            
            // creamos un paciente
            Paciente paciente = new Paciente();
            paciente.setNombre1("Luis");
            paciente.setApellido1("Lopez");
            paciente.setApellido2("Hernandez");
            
            // lo almacenamos
            paciente.guardar();
            // mostramos en la consola el identificador asignado al paciente
            System.out.println("Id " + paciente.getId() + " - " + paciente.getNombreCompleto());
            
            // obtenemos las propiedades del objeto y sus valores, utilizando la introspeccion
            // utilizando la biblioteca commons bean-utils
            Map<String, Object> propiedades = 
                    PropertyUtils.describe(paciente);
            
            // obtenemos los nombres de las propiedades
            Set<String> llaves = propiedades.keySet();
            
            // mostramos en la consola el nombre de las propiedades
            for(String llave : llaves) {
                System.out.println("Propiedad = " + llave);
            }
            
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
