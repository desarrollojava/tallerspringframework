/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidad;

import java.util.List;

/**
 *
 * @author admin
 */
public interface PersonaDao {

    void insertarPersona(Persona persona);

    void updatePersona(Persona persona);

    void deletePersona(Persona persona);

    Persona findPersonaById(int idPersona);

    List<Persona> findAllPersonas();

    int contadorPersonasByNombre(Persona persona);

    int contadorPersonas();

}
