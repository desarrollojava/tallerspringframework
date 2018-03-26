package com.profesor;

import org.springframework.stereotype.Component;

@Component("idBeanProfesor")
public class Profesor implements IInstructor {

    private int numeroAsignaturas = 8;

    public Profesor() {
    }

    public Profesor(int numeroAsignaturas) {
        this.numeroAsignaturas = numeroAsignaturas;
    }

    @Override
    public void ejecutar() throws EjecucionException {
        System.out.println("enseño " + numeroAsignaturas + " temas de matematica");
    }

    public void tomarExamen()  throws EjecucionException {
        System.out.println("se realiza la toma de examenes");

    }

    public int getNumeroAsignaturas() {
        return numeroAsignaturas;
    }

    public void setNumeroAsignaturas(int numeroAsignaturas) {
        this.numeroAsignaturas = numeroAsignaturas;
    }
}
