package com.ecaresoft.taller1.sih.modelo.entidades;

import com.ecaresoft.taller1.sih.modelo.actores.Medico;
import com.ecaresoft.taller1.sih.modelo.actores.Enfermera;
import com.ecaresoft.taller1.sih.modelo.base.Modelo;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de un consultorio. Contiene medicos y enfermeras asociados.
 * @author mrojas
 */
public class Consultorio extends Modelo {
     
    // medicos relacionados al consultorio.
    private List<Medico> medicosAsignados = new ArrayList<Medico>();
    
    // enfermeras relacionadas al consultorio.
    private List<Enfermera> enfermerasAsignadas = new ArrayList<Enfermera>();
    
    // ejemplo de sobrecarga
    
    /**
     * Asignamos un medico al consultorio.
     * @param medico El medico a relacionar.
     */
    public void asignar(Medico medico) {
        medicosAsignados.add(medico);
    }
    
    /**
     * Asignamos una enfermera al consultorio.
     * @param enfermera La enfermera a relacionar.
     */
    public void asignar(Enfermera enfermera) {
        enfermerasAsignadas.add(enfermera);
    }
    
}
