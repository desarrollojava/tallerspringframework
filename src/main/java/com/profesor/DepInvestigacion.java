/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.profesor;

import org.springframework.stereotype.Component;

@Component("idBeanDepInvestigacion")
public class DepInvestigacion implements IConsejoInvestigacion {

    @Override
    public void tomarDesicionesAdministrativas() {
        System.out.println("Asignar profesores para investigar");
    }

}
