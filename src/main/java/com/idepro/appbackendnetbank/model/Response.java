package com.idepro.appbackendnetbank.model;

import com.idepro.appbackendnetbank.util.MethodUtil;
import lombok.Data;

import java.util.Date;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 20/09/2020.
 */
@Data
public class Response<T> {
    private String mensaje;
    private String estado;
    private String fecha;
    private T data;

    public Response() {
        this.fecha = MethodUtil.dateDefault(new Date());
    }

    public Response(String mensaje, String estado, T data) {
        this.mensaje = mensaje;
        this.estado = estado;
        this.fecha = MethodUtil.dateDefault(new Date());
        this.data = data;
    }
}
