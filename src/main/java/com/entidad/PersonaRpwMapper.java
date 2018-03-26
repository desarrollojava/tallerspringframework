/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidad;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class PersonaRpwMapper implements  RowMapper<Persona>{

    @Override
    public Persona mapRow(ResultSet rs, int i) throws SQLException {
        Persona persona=new Persona();
        persona.setIdPersona(rs.getLong("idPersona"));
        persona.setApellidos(rs.getString("apellidos"));
        persona.setNombres(rs.getString("nombres"));
        persona.setDireccionDomicilio(rs.getString("direccionDomicilio"));
        return persona;
    }
    
}
