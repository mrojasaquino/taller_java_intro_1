/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecaresoft.taller1.sih.modelo.base;

import com.ecaresoft.taller1.sih.almacenamiento.BaseDatosMemoria;

/**
 *
 * @author mrojas
 */
public class Modelo {

    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public boolean guardar() {
        boolean retVal = false;
        
        retVal = BaseDatosMemoria.INSTANCIA.almacenar(this);
        
        return retVal;
    }
    
    
    public boolean borrar() {
        boolean retVal = false;
        
        
        return retVal;
    }
    
    
    public Modelo cargar(int id) {
        Modelo retVal = null;
        
        
        return retVal;
    }
}