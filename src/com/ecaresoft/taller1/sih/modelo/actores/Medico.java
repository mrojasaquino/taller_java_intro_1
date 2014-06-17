/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecaresoft.taller1.sih.modelo.actores;

import com.ecaresoft.taller1.sih.modelo.entidades.Direccion;
import com.ecaresoft.taller1.sih.modelo.base.Persona;

/**
 *
 * @author mrojas
 */
public class Medico extends Persona {
    
    private String cedulaProf;
    private Direccion[] direcciones;

    public String getCedulaProf() {
        return cedulaProf;
    }

    public void setCedulaProf(String cedulaProf) {
        this.cedulaProf = cedulaProf;
    }

    public Direccion[] getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Direccion[] direcciones) {
        this.direcciones = direcciones;
    }
    
}
