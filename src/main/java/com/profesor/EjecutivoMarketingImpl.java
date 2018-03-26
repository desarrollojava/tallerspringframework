/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.profesor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EjecutivoMarketingImpl implements IAdministrador {

    private String opiniones;

    @Pointcut("execution(* com.profesor.IPublico.darOpiniones(String)) && args(opiniones)")
    public void darOpiniones(String opiniones) { //metodo identificativo
    }

    @Before("darOpiniones(opiniones)")
    @Override
    public void recibirInformacion(String opiniones) {
        System.out.println("Recibiendo opinion");
        System.out.println(opiniones);
        this.opiniones=opiniones;
    }

    @Override
    public String getDevolverRespuesta() {
        
        return this.opiniones;
    }

}
