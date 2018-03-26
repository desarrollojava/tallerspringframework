/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aop;

import org.springframework.stereotype.Component;

@Component
public class Alumno {

    public void enviarTareas() {
        System.out.println("alumnos  envian tareas");
    }

    public void getRecibirNotas() {
        System.out.println("alumnos  reciben notas");
    }
    
     public void darExamen() {
        System.out.println("alumnos  reciben notas");
    }

}
