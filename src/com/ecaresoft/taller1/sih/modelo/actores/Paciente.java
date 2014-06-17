package com.ecaresoft.taller1.sih.modelo.actores;

import com.ecaresoft.taller1.sih.modelo.base.Persona;
import com.ecaresoft.taller1.sih.modelo.entidades.Direccion;

/**
 * Modelo de datos de un paciente.
 * @author mrojas
 */
public class Paciente extends Persona {
    private Direccion lugarResidencia;
    private Direccion lugarNacimiento;

    public Direccion getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(Direccion lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public Direccion getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(Direccion lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }
}
