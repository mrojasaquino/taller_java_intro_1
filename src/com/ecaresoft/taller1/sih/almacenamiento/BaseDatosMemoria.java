/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecaresoft.taller1.sih.almacenamiento;

import com.ecaresoft.taller1.sih.modelo.base.Modelo;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;


/**
 *
 * @author mrojas
 */
public enum BaseDatosMemoria {
    
    INSTANCIA;
    
    private Map<String, Map<Integer, Modelo>> baseDatos;
    private Map<String, Integer> secuencias;
    
    BaseDatosMemoria() {
        baseDatos = new HashMap<String, Map<Integer, Modelo>>();
        secuencias = new HashMap<String, Integer>();
    }
    
    public boolean almacenar(Modelo modelo) {
        boolean retVal = false;
        
        String tabla = ClassUtils.getShortClassName(modelo.getClass());
        
        System.out.println("Procesando tabla : " + tabla);
        
        if(modelo.getId() == 0) {
            modelo.setId(getSecuencia(tabla));
        }
        
        if(baseDatos.containsKey(tabla)) {
            baseDatos.get(tabla).put(modelo.getId(), modelo);
        }
        
        return retVal;
    }
    
    
    private Integer getSecuencia(String nombreTabla) {
        Integer secuencia = null;
        
        if(secuencias.containsKey(nombreTabla)) {
            secuencia = secuencias.get(nombreTabla);
        } else {
            secuencia = 0;
        }
        
        secuencia += 1;
        
        secuencias.put(nombreTabla, secuencia);
        
        return secuencia;
    }
}
