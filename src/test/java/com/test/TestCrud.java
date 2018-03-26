/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.entidad.Persona;
import com.entidad.PersonaDao;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/jdbc/dataSource-test.xml",
    "classpath:/com/configuracion/spring/applicationContext.xml"})
public class TestCrud {

    private static Log logger = LogFactory.getLog(TestCrud.class);

    @Autowired
    private PersonaDao personaDao;  //new personadaoimpl

    @org.junit.Test
    public void TestJdbc() {
        try {

            List<Persona> lista = personaDao.findAllPersonas();
            for (Persona obj : lista) {
                logger.info("nombre:-->" + obj.getNombres());
            }
            
//
//        
        } catch (Exception e) {
            logger.error("error JDBC" + e);
        }

    }
}
