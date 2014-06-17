package com.ecaresoft.taller1.sih.modelo.entidades;

import com.ecaresoft.taller1.sih.modelo.actores.Medico;
import com.ecaresoft.taller1.sih.modelo.actores.Paciente;
import com.ecaresoft.taller1.sih.modelo.base.Modelo;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.sql.Timestamp;
import java.util.Calendar;
import org.apache.commons.lang3.StringUtils;

/**
 * Modelo de una cirugia.
 * @author mrojas
 */
public class Cirugia extends Modelo {

    private Medico cirujano;
    private Medico anestesiologo;
    private Paciente paciente;
    private Timestamp fechaCirugia;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private boolean ejecutandose = false;
    private boolean cerrada = false;
    private boolean cancelada = false;

    
    public Cirugia() {
        throw new IllegalArgumentException("Debe proporcionar datos de paciente y cirujano");
    }
    
    public Cirugia(Medico cirujano, Paciente paciente, Timestamp fechaCirugia) {
        super();

        // usamos Google Guava Preconditions para mejorar la legibilidad
        Preconditions.checkNotNull(cirujano, "Debe proporcionar un cirujano.");
        Preconditions.checkNotNull(paciente, "Debe proporcionar un paciente.");
        Preconditions.checkState(!paciente.isFinado(), "No puede asignar una cirugia a un paciente finado.");
        
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

    /**
     * Sobre escritura del metodo toString de la clase Object. Devuelve una
     * representacion textual del objeto.
     * @return una cadena de texto con los datos relevantes de la cirugia.
     */
    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder();
        
        mensaje.append("Cirugia : [ Cirujano : ")
                .append(cirujano == null ? StringUtils.EMPTY : cirujano.getNombreCompleto())
                .append(" | Anestesiologo : ")
                .append(anestesiologo == null ? StringUtils.EMPTY : anestesiologo.getNombreCompleto())
                .append(" | Paciente : ")
                .append(paciente == null ? StringUtils.EMPTY : paciente.getNombreCompleto())
                .append(" | Fecha : ")
                .append(Objects.firstNonNull(fechaCirugia, "Sin fecha aun")).append(" ]");
        
        return mensaje.toString();
    }

    
    
}
