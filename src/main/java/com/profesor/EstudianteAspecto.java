/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.profesor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class EstudianteAspecto {

    public void sentarse() {
        System.out.println("alumnos sentados");
    }

    public void apagarCelulares() {
        System.out.println("alumnos  apagan sus celulares");
    }

    public void realizarPreguntas() {
        System.out.println("alumnos  realizan preguntas");
    }

    public void salirDelAula() {
        System.out.println("alumnos  salen del aula");
    }

    public void getRecibirNotas() {
        System.out.println("alumnos  reciben notas");
    }
    
      //segundo ejemplo
    public void monitorearClasesMatematica(ProceedingJoinPoint joinjPoint) {
        try {
            System.out.println("las clases estan por comenzar, por favor tomar asiento");
            System.out.println("Por favor apagar los celulares");
            
                    
            
            long horaInicio = System.currentTimeMillis();//hora de inicio
            //se llama al metodo de negocio (metodo objetivo)
            joinjPoint.proceed();
            Thread.sleep(1000);
            //1 segundo
            //Este delay enmilisegundos  es opcional y se puede poner en los metodos de negocio para simular la duracion delmetodo
            System.out.println("las clases han finalizado, por favor realizar preguntas");
            long horaTermino = System.currentTimeMillis();
            System.out.println("las clases duraron:" + (horaTermino - horaInicio));

        } catch (Throwable t) {
            System.out.println("Los alumnos han finalizado las clases.");
        }
    }

}
