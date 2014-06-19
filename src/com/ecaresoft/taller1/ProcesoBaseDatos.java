/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecaresoft.taller1;

import com.ecaresoft.taller1.sih.modelo.actores.Medico;
import java.util.logging.Logger;

/**
 *
 * @author mrojas
 */
public class ProcesoBaseDatos {
    
    
    public static void main(String[] args) {
        
        Logger logger = Logger.getLogger(ProcesoBaseDatos.class.getName());
        
        Medico medico = new Medico();
        medico.setNombre1("Miguel");
        medico.setNombre2("Angel");
        medico.setApellido1("Rojas");
        medico.setApellido2("Aquino");
        medico.setCedulaProf("abc123");
        medico.setSexo("H");
        if(medico.guardar()) {
            logger.severe("El registro se guardó exitosamente.");
        } else {
            logger.severe("No se guardó el registro del médico.");
        }
        
    }

}
