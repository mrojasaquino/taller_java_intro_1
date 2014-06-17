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
 *
 * @author mrojas
 */
public class Proceso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Medico medico = new Medico();
            medico.setNombre1("Miguel");
            medico.setNombre2("Angel");
            medico.setApellido1("Rojas");
            medico.setApellido2("Aquino");
            
            medico.guardar();
            System.out.println("Id " + medico.getId() + " - " + medico.getNombreCompleto());
            
            medico = new Medico();
            medico.setNombre1("Francisco");
            medico.setNombre2("Omar");
            medico.setApellido1("De la Rosa");
            medico.setApellido2("Palacios");
            
            medico.guardar();
            System.out.println("Id " + medico.getId() + " - " + medico.getNombreCompleto());
            
            Paciente paciente = new Paciente();
            paciente.setNombre1("Luis");
            paciente.setApellido1("Lopez");
            paciente.setApellido2("Hernandez");
            
            paciente.guardar();
            System.out.println("Id " + paciente.getId() + " - " + paciente.getNombreCompleto());
            
            Map<String, Object> propiedades = 
                    PropertyUtils.describe(paciente);
            Set<String> llaves = propiedades.keySet();
            
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
