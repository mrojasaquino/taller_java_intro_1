package com.ecaresoft.taller1.sih.modelo.actores;

import com.ecaresoft.taller1.sih.modelo.entidades.Direccion;

/**
 * Modelo de datos de una enfermera.
 * @author mrojas
 */
public class Enfermera {
    
    // arreglo de las posibles direcciones de la enfermera.
    private Direccion[] direcciones;

    public Direccion[] getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Direccion[] direcciones) {
        this.direcciones = direcciones;
    }
    
    
}
