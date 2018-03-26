/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidad;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaDaoImpl implements PersonaDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void updatePersona(Persona persona) {
      
    }

    @Override
    public void deletePersona(Persona persona) {
      
    }

    @Override
    public Persona findPersonaById(int idPersona) {
        Persona persona = null;
       
        return persona;
    }

    @Override
    public List<Persona> findAllPersonas() {

        return this.jdbcTemplate.query("select idPersona, nombres,apellidos,direccionDomicilio "
                + "from persona", new PersonaRpwMapper());
    }

    @Override
    public int contadorPersonasByNombre(Persona persona) {
        
        return 0;
    }

    @Override
    public int contadorPersonas() {
        String sql = "select count(*) from Persona";
        return this.jdbcTemplate.queryForObject(sql, int.class);
    }

    @Override
    public void insertarPersona(Persona persona) {
       
    }

}
