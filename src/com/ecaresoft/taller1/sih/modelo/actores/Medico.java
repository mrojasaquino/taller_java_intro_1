package com.ecaresoft.taller1.sih.modelo.actores;

import com.ecaresoft.taller1.sih.modelo.entidades.Direccion;
import com.ecaresoft.taller1.sih.modelo.base.Persona;

/**
 * Modelo de datos de un medico.
 * @author mrojas
 */
public class Medico extends Persona {
    
    // cedula profesional
    private String cedulaProf;
    
    // las posibles direcciones del medico
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
