/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecaresoft.taller1.sih.almacenamiento;

import com.ecaresoft.taller1.sih.modelo.base.Modelo;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;


/**
 * Base de datos falsa. Utiliza mecanismos de introspeccion para determinar la
 * clase a la que pertenece un objeto para crear o localizar la "tabla" en la que
 * se deben almacenar o recuperar los datos.
 * @author mrojas
 */
public enum BaseDatosMemoria {
    
    // utilizamos el patrón "singleton" para tener una sola instancia del mecanismo
    // de base de datos (http://en.wikipedia.org/wiki/Singleton_pattern)
    INSTANCIA;
    
    //modelo de base de datos, se utiliza un mapa llave / valor en el cual la
    //llave es el nombre de la tabla y el valor es otro mapa en el que la llave
    //es un valor entero (a manera de identificador) y el valor correspondiente
    //es una instancia de la clase Modelo
    private Map<String, Map<Integer, Modelo>> baseDatos;
    
    //secuencias para las tablas, la llave es el nombre de la tabla y el valor
    //es un entero correspondiente al siguiente numero de secuencia a asignar
    private Map<String, Integer> secuencias;
    
    /**
     * Constructor por defecto. Instanciamos los mapas correspondientes a las
     * "tablas" y "secuencias".
     */
    BaseDatosMemoria() {
        baseDatos = new HashMap<String, Map<Integer, Modelo>>();
        secuencias = new HashMap<String, Integer>();
    }
    
    /**
     * Almacenamos en la base de datos los datos contenidos en un Modelo.
     * @param modelo El objeto con los datos a almacenar.
     * @return un valor booleano indicando si fue posible o no guardar el 
     * "registro"
     */
    public boolean almacenar(Modelo modelo) {
        boolean retVal = false;
        
        //determinamos el nombre de la clase para determinar que "tabla" se utilizara
        //utilizamos clases de utilería de commons-lang.
        String tabla = ClassUtils.getShortClassName(modelo.getClass());
        
        System.out.println("Procesando tabla : " + tabla);
        
        // si no tenemos un valor en el campo de identificador ...
        if(modelo.getId() == 0) {
            // obtenemos el siguiente valor en la secuencia relacionada a la "tabla"
            modelo.setId(getSecuencia(tabla));
        }
        
        // si no existe aun la tabla en la base de datos la creamos
        if(!baseDatos.containsKey(tabla)) {
            baseDatos.put(tabla, new HashMap<Integer, Modelo>());
        }
        
        //almacenamos el objeto en la tabla
        baseDatos.get(tabla).put(modelo.getId(), modelo);
        
        // como esta implementación es ficticia, solo para demostracion, siempre
        // devolvemos un valor verdadero.
        retVal = true;
        
        return retVal;
    }
    

    /**
     * Obtenemos el siguiente valor de la secuencia relacionada a la tabla y lo
     * actualiza.
     * @param nombreTabla El nombre de la tabla de la que se desea la secuencia.
     * @return El siguiente valor en la secuencia.
     */
    private Integer getSecuencia(String nombreTabla) {
        Integer secuencia = null;
        
        // determinamos la secuencia a utilizar en base al nombre de la tabla
        if(secuencias.containsKey(nombreTabla)) {
            // si ya existe la recuperamos
            secuencia = secuencias.get(nombreTabla);
        } else {
            // de lo contrario la iniciamos en 0
            secuencia = 0;
        }
        
        // incrementamos el valor
        secuencia += 1;
        
        // lo almacenamos
        secuencias.put(nombreTabla, secuencia);
        
        // devolvemos el valor
        return secuencia;
    }
}
