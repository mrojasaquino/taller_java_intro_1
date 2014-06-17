/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecaresoft.taller1.sih.modelo.entidades;

import com.ecaresoft.taller1.sih.modelo.actores.Medico;
import com.ecaresoft.taller1.sih.modelo.actores.Enfermera;
import com.ecaresoft.taller1.sih.modelo.base.Modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrojas
 */
public class Consultorio extends Modelo {
    
    private List<Medico> medicosAsignados = new ArrayList<Medico>();
    private List<Enfermera> enfermerasAsignadas = new ArrayList<Enfermera>();
    
    // ejemplo de sobrecarga
    
    public void asignar(Medico medico) {
        medicosAsignados.add(medico);
    }
    
    public void asignar(Enfermera enfermera) {
        enfermerasAsignadas.add(enfermera);
    }
    
}
