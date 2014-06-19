/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecaresoft.taller1.sih.almacenamiento;

import com.ecaresoft.taller1.Proceso;
import com.ecaresoft.taller1.sih.modelo.base.Modelo;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.postgresql.ds.PGSimpleDataSource;

/**
 *
 * @author mrojas
 */
public enum BaseDatosPg {

    INSTANCIA;

    private String jdbcDriver = "org.postgresql.Driver";
    private String jdbcUser = "ecaresoft";
    private String jdbcPasword = "ecaresoft";
    private String jdbcHost = "localhost";
    private String jdbcDb = "HIS";
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
        StringBuilder sql = new StringBuilder();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        // si tenemos un valor > 0 en el identificador del modelo, entonces es una
        // actualizacion, de lo contrario es insercion
        if(modelo.getId() > 0) {
            try {
                sql.append("UPDATE ").append(tabla).append(" SET ");
                
                //determinamos las propiedades del modelo
                Map<String, Object> propiedades = PropertyUtils.describe(modelo);
                for (String propiedad : propiedades.keySet()) {
                    if(!"id".equals(propiedad)) {
                        sql.append(propiedad).append(" = ?, ");
                    }
                }
                
                sql = new StringBuilder(StringUtils.removeEnd(sql.toString(), ", "));
                
                con = ds.getConnection();
                pstmt = con.prepareStatement(sql.toString());
                
                //asignamos los valores a los parametros
                int idx = 1;
                for (String propiedad : propiedades.keySet()) {
                    if(!"id".equals(propiedad)) {
                        // determinamos el tipo de la propiedad para asignar el valor
                        // correcto en la base de datos.
                        Object valor = propiedades.get(propiedad);
                        
                        if(valor instanceof String) {
                            pstmt.setString(idx++, (String)valor);
                        } else if(valor instanceof Boolean) {
                            pstmt.setBoolean(idx++, (Boolean)valor);
                        } if(valor instanceof Integer) {
                            pstmt.setInt(idx++, (Integer)valor);
                        } if(valor instanceof Long) {
                            pstmt.setLong(idx++, (Long)valor);
                        } if(valor instanceof Double) {
                            pstmt.setDouble(idx++, (Double)valor);
                        } if(valor instanceof BigDecimal) {
                            pstmt.setBigDecimal(idx++, (BigDecimal)valor);
                        } if(valor instanceof Timestamp) {
                            pstmt.setTimestamp(idx++, (Timestamp)valor);
                        }
                    }
                }
                
                int registros = pstmt.executeUpdate();
                
                logger.info("Registros actualizados : " + registros);
                
                retVal = true;
                
            } catch (IllegalAccessException ex) {
                logger.log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                logger.log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                logger.log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            } finally {
                cerrarRecursos(null, pstmt);
            }
        } else {
            // es un registro que debemos insertar
            sql = new StringBuilder("INSERT INTO ");
            sql.append(tabla).append('(');
            
            Map<String, Object> propiedades;
            try {
                
                propiedades = PropertyUtils.describe(modelo);
                for (String propiedad : propiedades.keySet()) {
                    if (!"id".equals(propiedad) 
                            && propiedades.get(propiedad) != null
                            && !propiedades.get(propiedad).getClass().isArray()
                            && !"class".equals(propiedad)
                            && !"nombreCompleto".equals(propiedad)) {
                        sql.append(propiedad).append(", ");
                    }
                }
                
                sql = new StringBuilder(StringUtils.removeEnd(sql.toString(), ", "));
                
                sql.append(") VALUES (");
                
                for (String propiedad : propiedades.keySet()) {
                    if(!"id".equals(propiedad)
                            && propiedades.get(propiedad) != null
                            && !propiedades.get(propiedad).getClass().isArray()
                            && !"class".equals(propiedad)
                            && !"nombreCompleto".equals(propiedad)) {
                        sql.append("?, ");
                    }
                }
                
                sql = new StringBuilder(StringUtils.removeEnd(sql.toString(), ", "));
                sql.append(')');
                
                logger.info("SQL : " + sql);
                
                con = ds.getConnection();
                pstmt = con.prepareStatement(sql.toString());

                //asignamos los valores a los parametros
                int idx = 1;
                for (String propiedad : propiedades.keySet()) {
                    Object valor = propiedades.get(propiedad);

                    logger.info("Indice = " + idx + ", Propiedad = " + propiedad + ", Valor = " + valor);
                    
                    if(!"id".equals(propiedad)
                            && valor != null
                            && !propiedades.get(propiedad).getClass().isArray()
                            && !"class".equals(propiedad)
                            && !"nombreCompleto".equals(propiedad)) {
                        // determinamos el tipo de la propiedad para asignar el valor
                        // correcto en la base de datos.
                        
                        if(valor instanceof String) {
                            pstmt.setString(idx++, (String)valor);
                        } else if(valor instanceof Boolean) {
                            pstmt.setBoolean(idx++, (Boolean)valor);
                        } else if(valor instanceof Integer) {
                            pstmt.setInt(idx++, (Integer)valor);
                        } else if(valor instanceof Long) {
                            pstmt.setLong(idx++, (Long)valor);
                        } else if(valor instanceof Double) {
                            pstmt.setDouble(idx++, (Double)valor);
                        } else if(valor instanceof BigDecimal) {
                            pstmt.setBigDecimal(idx++, (BigDecimal)valor);
                        } else if(valor instanceof Timestamp) {
                            pstmt.setTimestamp(idx++, (Timestamp)valor);
                        }
                    }
                }
                
                int registros = pstmt.executeUpdate();
                
                logger.info("Registros insertados : " + registros);
             
                retVal = true;
                
            } catch (IllegalAccessException ex) {
                logger.log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                logger.log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                logger.log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }  finally {
                cerrarRecursos(null, pstmt);
            }
        } 
        
        return retVal;
    }
    
    
    private void cerrarRecursos(ResultSet rs, PreparedStatement pstmt) {

        try {

            if (pstmt != null) {
                pstmt.close();
            }

            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
