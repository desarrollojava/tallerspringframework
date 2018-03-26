/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.profesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("idBeanProfesorMatematicaFisica")
public class ProfesorMatematicaFisica extends Profesor{
    private IFisica iFisica;

    public ProfesorMatematicaFisica(IFisica iFisica) {
        super();
        this.iFisica = iFisica;
    }

    @Autowired
    public ProfesorMatematicaFisica(@Value("3") int numeroAsignaturas,IFisica iFisica) {
        super(numeroAsignaturas);
        this.iFisica = iFisica;
    }
    
    @Override
    public void ejecutar() throws EjecucionException{
        super.ejecutar();
        System.out.println("y tambien enseña fisica practica de movimiento rectilineo");
        iFisica.enseniarFisicaPractica();
        System.out.println("fin");
        
    }
}
