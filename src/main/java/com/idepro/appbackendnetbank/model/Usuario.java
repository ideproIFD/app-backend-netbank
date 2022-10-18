package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 25/11/2020.
 */
@Data
@AllArgsConstructor
public class Usuario {
    private String usuario;
    private String password;
    private String nombre;
    private String descripcion;
    private String email;
    private String estado;
    @JsonProperty("add_user")
    private String addUser;
    private String hora;
    @JsonProperty("add_date")
    private String addDate;
    @JsonProperty("id_rol")
    private Integer idRol;

    public Usuario() {
    }
}
