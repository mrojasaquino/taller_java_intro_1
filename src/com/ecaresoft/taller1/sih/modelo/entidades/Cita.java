/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecaresoft.taller1.sih.modelo.entidades;

import com.ecaresoft.taller1.sih.modelo.actores.Medico;
import com.ecaresoft.taller1.sih.modelo.actores.Paciente;
import com.ecaresoft.taller1.sih.modelo.base.Modelo;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author mrojas
 */
public class Cita extends Modelo {
    
    private Medico medico;
    private Paciente paciente;
    private Timestamp fechaCita;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private boolean ejecutandose = false;
    private boolean cerrada = false;
    private boolean cancelada = false;
    
    public Cita(Medico medico, Paciente paciente, Timestamp fechaCita) {
        super();
        
        this.medico = medico;
        this.paciente = paciente;
        this.fechaCita = fechaCita;
    }
    
    
    public void iniciar() {
        fechaInicio = new Timestamp(Calendar.getInstance().getTimeInMillis());
        ejecutandose = true;
    }
    
    public void terminar() {
        fechaFin = new Timestamp(Calendar.getInstance().getTimeInMillis());
        ejecutandose = false;
    }
    
    public void cancelar() {
        cancelada = true;
    }
    
    public void cerrar() {
        cerrada = true;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Timestamp getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Timestamp fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEjecutandose() {
        return ejecutandose;
    }

    public void setEjecutandose(boolean ejecutandose) {
        this.ejecutandose = ejecutandose;
    }

    public boolean isCerrada() {
        return cerrada;
    }

    public void setCerrada(boolean cerrada) {
        this.cerrada = cerrada;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }
    
}
