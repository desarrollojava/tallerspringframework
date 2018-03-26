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
//            int totalPersonasPorNombre = personaDao.contadorPersonasByNombre(lista.get(0));
//            logger.info("total Personas por nombre -->" + lista.get(0).getNombres() + ":" + totalPersonasPorNombre);
//
//            Persona person = new Persona();
//            person.setApellidos("Hernandez");
//            person.setDireccionDomicilio("Quito");
//            person.setNombres("Ramiro");
//            personaDao.insertarPersona(person);
//
//            int totalPersonas = personaDao.contadorPersonas();
//            logger.info("total Personas-->" + totalPersonas);

            Persona persona = personaDao.findPersonaById((int) lista.get(0).getIdPersona());
            logger.info("Persona obtenida-->" + persona.getApellidos() + " " + persona.getNombres() + " " + persona.getIdPersona());
            persona.setApellidos("Quintana");
            persona.setDireccionDomicilio("Manabi");
            persona.setNombres("Felipe");
            personaDao.updatePersona(persona);

            int totalPersonasPorNombre = personaDao.contadorPersonasByNombre(persona);
            logger.info("total Personas por nombre -->" + persona.getNombres() + ":" + totalPersonasPorNombre);

            personaDao.deletePersona(persona);
            int totalPersonasPorNombreFelipe = personaDao.contadorPersonasByNombre(persona);
            logger.info("total Personas por nombre -->" + persona.getNombres() + ":" + totalPersonasPorNombreFelipe);

//        long numero = jdbcTemplate.queryForObject("select count(*) from persona", Long.class);
//        logger.info("numero de perfsonas:-->" + numero);
        } catch (Exception e) {
            logger.error("error JDBC" + e);
        }

    }
}
