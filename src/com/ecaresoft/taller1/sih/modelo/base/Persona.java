package com.ecaresoft.taller1.sih.modelo.base;

import java.sql.Timestamp;
import org.apache.commons.lang3.StringUtils;

/**
 * Modelo de datos para una persona. Extiende del modelo de datos generico.
 * @author mrojas
 */
public class Persona extends Modelo {

    private String nombre1;
    private String nombre2;
    private String nombre3;
    private String apellido1;
    private String apellido2;
    private String apellido3;
    private String sexo;
    private Timestamp fechNac;

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNombre3() {
        return nombre3;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getApellido3() {
        return apellido3;
    }

    public void setApellido3(String apellido3) {
        this.apellido3 = apellido3;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Timestamp getFechNac() {
        return fechNac;
    }

    public void setFechNac(Timestamp fechNac) {
        this.fechNac = fechNac;
    }
    
    /**
     * Devolvemos el nombre completo de la persona a partir de los datos individuales.
     * @return El nombre completo.
     */
    public String getNombreCompleto() {
        StringBuilder nombreCompleto = new StringBuilder();
        
        nombreCompleto.append(getNombre1());
        
        // utilizamos las clases de utileria de commons-lang para determinar si
        // la cadena de texto esta vacia o es nula incluso
        if(StringUtils.isNotEmpty(getNombre2())) {
            nombreCompleto.append(' ').append(getNombre2());
        }
        
        if(StringUtils.isNotEmpty(getNombre3())) {
            nombreCompleto.append(' ').append(getNombre3());
        }
        
        if(StringUtils.isNotEmpty(getApellido1())) {
            nombreCompleto.append(' ').append(getApellido1());
        }
        
        if(StringUtils.isNotEmpty(getApellido2())) {
            nombreCompleto.append(' ').append(getApellido2());
        }
        
        if(StringUtils.isNotEmpty(getApellido3())) {
            nombreCompleto.append(' ').append(getApellido3());
        }
        
        return nombreCompleto.toString();
    }
}
