/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.profesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMultifuncion {
    
   
    public void tomarExamen()  throws EjecucionException {
        System.out.println("se realiza la toma de examenes");

    }

    public void darNotas()  throws EjecucionException {
        System.out.println("se dictan las notas");

    }
}
