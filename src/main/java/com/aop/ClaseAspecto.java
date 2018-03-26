package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class ClaseAspecto {

    public void sentarse() {
        System.out.println("las clases estan por comenzar, por favor tomar asiento");
    }

    public void apagarCelulares() {
        System.out.println("Por favor apagar los celulares");
    }

    public void realizarPreguntas() {
        System.out.println("las clases han finalizado, realizar preguntas");
    }

    public void salirDelAula() {
        System.out.println("las clases se han concluido, salir del aula");
    }

    @Pointcut("execution(* com.aop.Alumno.enviarTareas(..)) ||  execution(* com.aop.Alumno.darExamen(..))")
    public void emitirFuncionAspecto() {  //identificativo
    }

    @Around("emitirFuncionAspecto()")
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
