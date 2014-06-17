/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecaresoft.taller1.sih.modelo.entidades;

import com.ecaresoft.taller1.sih.modelo.actores.Medico;
import com.ecaresoft.taller1.sih.modelo.actores.Paciente;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author mrojas
 */
public class Cirugia {

    private Medico cirujano;
    private Medico anestesiologo;
    private Paciente paciente;
    private Timestamp fechaCirugia;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private boolean ejecutandose = false;
    private boolean cerrada = false;
    private boolean cancelada = false;

    public Cirugia(Medico cirujano, Paciente paciente, Timestamp fechaCirugia) {
        super();

        this.cirujano = cirujano;
        this.paciente = paciente;
        this.fechaCirugia = fechaCirugia;
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

    public Medico getCirujano() {
        return cirujano;
    }

    public void setCirujano(Medico cirujano) {
        this.cirujano = cirujano;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Timestamp getFechaCirugia() {
        return fechaCirugia;
    }

    public void setFechaCirugia(Timestamp fechaCirugia) {
        this.fechaCirugia = fechaCirugia;
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
    
    public Medico getAnestesiologo() {
        return anestesiologo;
    }

    public void setAnestesiologo(Medico anestesiologo) {
        this.anestesiologo = anestesiologo;
    }

    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder();
        
        mensaje.append("[ Cirujano : ").append(cirujano.getNombreCompleto())
                .append(" | Anestesiologo : ").append(anestesiologo.getNombreCompleto())
                .append(" | Paciente : ").append(paciente.getNombreCompleto())
                .append(" | Fecha : ").append(fechaCirugia).append(" ]");
        
        return super.toString(); 
    }

    
    
}
