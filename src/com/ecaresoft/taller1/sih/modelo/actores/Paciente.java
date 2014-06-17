/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecaresoft.taller1.sih.modelo.actores;

import com.ecaresoft.taller1.sih.modelo.base.Persona;
import com.ecaresoft.taller1.sih.modelo.entidades.Direccion;

/**
 *
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
