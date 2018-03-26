/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.profesor;

import org.springframework.stereotype.Component;

@Component("idBeanMovimientoRectilineo")
public class MovimientoRectilineo implements IFisica{

    @Override
    public void enseniarFisicaPractica() {
            String experimentoPractico="Dejo caer una pelota a 10 mts de altura"
                    + " y se calcula la velocidad final de llegada "
                    + " y el tiempo que se demoro en llegar a la tierra.";
            System.out.println("Experimento practico:-->"+experimentoPractico);
            
        }
    
}
