/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.aop.Alumno;
import com.aop.Instituto;
import com.profesor.IAdministrador;
import com.profesor.IInstructor;
import com.profesor.IPublico;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/configuracion/spring/applicationContext.xml"})
public class Test {

    private static Log logger = LogFactory.getLog(Test.class);

    @Autowired
    private Alumno claseAspecto;

    @Autowired
    private Instituto instituto;

    @Autowired
    @Qualifier("idBeanProfesor")
    private IInstructor Iinstructor;

    @Autowired
    private IAdministrador iAdministrador;

    @Autowired
    private IPublico iPublico;

    @org.junit.Test
    public void testProfesor() {
        iPublico.darOpiniones("dar mi opinion");
        logger.info(iAdministrador.getDevolverRespuesta());
        
        
//        claseAspecto.darExamen();
//        Iinstructor.ejecutar();

//        instituto.emitirCertificado();
    }

}
