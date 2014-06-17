package com.ecaresoft.taller1.sih.modelo.entidades;

import com.ecaresoft.taller1.sih.modelo.base.Modelo;

/**
 * Modelo de datos de una direccion fisica.
 * @author mrojas
 */
public class Direccion extends Modelo {
 
    private String calle1;
    private String calle2;
    private String colonia;
    private String localidad;
    private String estado;
    private int codPost;

    public String getCalle1() {
        return calle1;
    }

    public void setCalle1(String calle1) {
        this.calle1 = calle1;
    }

    public String getCalle2() {
        return calle2;
    }

    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodPost() {
        return codPost;
    }

    public void setCodPost(int codPost) {
        this.codPost = codPost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Direccion [ calle1=").append(calle1)
                .append("| calle2=").append(calle2)
                .append("| colonia=").append(colonia)
                .append("| localidad=").append(localidad)
                .append("| estado=").append(estado)
                .append("| codPost=").append(codPost).append(" ]");
        
        return sb.toString();
    }

    
    
}
