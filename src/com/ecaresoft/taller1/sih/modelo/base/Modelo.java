package com.ecaresoft.taller1.sih.modelo.base;

import com.ecaresoft.taller1.sih.almacenamiento.BaseDatosMemoria;
import com.ecaresoft.taller1.sih.almacenamiento.BaseDatosPg;

/**
 * Modelo basico de datos. Contiene las operaciones basicas que todo objeto que
 * sea susceptible de ser almacenado debe poder ejecutar.
 * @author mrojas
 */
public class Modelo {

    // identificador numerico del objeto
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Almacenamos el objeto actual en el mecanismo de persistencia subyacente.
     * @return un valor booleano para indicar si se almaceno o no el objeto.
     */
    public boolean guardar() {
        boolean retVal = false;
        
        // invocamos el motor de base de datos
//        retVal = BaseDatosMemoria.INSTANCIA.almacenar(this);
        retVal = BaseDatosPg.INSTANCIA.almacenar(this);
        
        return retVal;
    }
    
    
    /**
     * Borramos de la base de datos el objeto.
     * @return un valor booleano indicando si se borro o no el objeto.
     */
    public boolean borrar() {
        boolean retVal = false;
        
        
        return retVal;
    }
    
    
    /**
     * Cargamos un objeto a partir del identificador numerico proporcionado.
     * @param id el identificador del objeto a cargar.
     * @return un modelo de datos.
     */
    public Modelo cargar(int id) {
        Modelo retVal = null;
        
        
        return retVal;
    }
}