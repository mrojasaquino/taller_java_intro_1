/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecaresoft.taller1.sih.almacenamiento;

import com.ecaresoft.taller1.Proceso;
import com.ecaresoft.taller1.sih.modelo.base.Modelo;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.apache.commons.lang3.ClassUtils;
import org.postgresql.ds.PGSimpleDataSource;

/**
 *
 * @author mrojas
 */
public enum BaseDatosPg {

    INSTANCE;

    private String jdbcDriver = "org.postgresql.Driver";
    private String jdbcUser = "ecaresoft";
    private String jdbcPasword = "ecaresoft";
    private String jdbcHost = "localhost";
    private String jdbcDb = "his";
    private Logger logger = Logger.getLogger(Proceso.class.getName());
    private PGSimpleDataSource ds = null;
    
    BaseDatosPg() {
        try {
            init();
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    private void init() throws ClassNotFoundException {
        Class.forName(jdbcDriver);
        ds = new PGSimpleDataSource();
        ds.setUser(jdbcUser);
        ds.setPassword(jdbcPasword);
        ds.setServerName(jdbcHost);
        ds.setDatabaseName(jdbcDb);
    }
    
    
    public boolean almacenar(Modelo modelo) {
        boolean retVal = false;
        
        String tabla = ClassUtils.getShortClassName(modelo.getClass());
        
        
        
        return retVal;
    }
}
