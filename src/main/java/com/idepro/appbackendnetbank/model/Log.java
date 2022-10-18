package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 14/7/2021.
 */
@Data
public class Log {
    private String usuario;
    private String nombre;
    @JsonProperty("direccion_url")
    private String direccionUrl;
    private String respuesta;
    @JsonProperty("ubicacion_detalle")
    private String ubicacionDetalle;
    @JsonProperty("add_user")
    private String addUser;
    private String hora;
    @JsonProperty("add_date")
    private String addDate;

    public Log(String usuario, String nombre, String direccionUrl, String respuesta, String ubicacionDetalle, String addUser) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.direccionUrl = direccionUrl;
        this.respuesta = respuesta;
        this.ubicacionDetalle = ubicacionDetalle;
        this.addUser = addUser;
    }
}
