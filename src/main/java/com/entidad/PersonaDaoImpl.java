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
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(persona);
        String sql = "update persona set nombres=:nombres,apellidos=:apellidos,direccionDomicilio=:direccionDomicilio where idPersona=:idPersona";
        this.namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    @Override
    public void deletePersona(Persona persona) {
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(persona);
        String sql = "delete persona  where idPersona=:idPersona";
        this.namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    @Override
    public Persona findPersonaById(int idPersona) {
        Persona persona = null;
        try {
            //parametros por indice  ?
            persona = jdbcTemplate.queryForObject("select * from persona where idPersona=?", new PersonaRpwMapper(), idPersona);

        } catch (EmptyResultDataAccessException e) {
            persona = null;

        }
        return persona;
    }

    @Override
    public List<Persona> findAllPersonas() {

        return this.jdbcTemplate.query("select idPersona, nombres,apellidos,direccionDomicilio "
                + "from persona", new PersonaRpwMapper());
    }

    @Override
    public int contadorPersonasByNombre(Persona persona) {
        String sql = "select count(*) from Persona where nombres=:nombres";
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(persona);
        return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, int.class);
    }

    @Override
    public int contadorPersonas() {
        String sql = "select count(*) from Persona";
        return this.jdbcTemplate.queryForObject(sql, int.class);
    }

    @Override
    public void insertarPersona(Persona persona) {
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(persona);
        String sql = "insert into persona(nombres,apellidos,direccionDomicilio) values(:nombres,:apellidos,:direccionDomicilio)";
        this.namedParameterJdbcTemplate.update(sql, namedParameters);
    }

}
