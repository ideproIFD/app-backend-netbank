package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 22/09/2020.
 */
@Data
public class Request {

    private String usuario;
    private String estado;

    private String ci;
    @JsonProperty("id_prestamo")
    private Integer idPrestamo;
    @JsonProperty("id_cliente")
    private Integer idCliente;
    @JsonProperty("numero_documento")
    private String numeroDocumento;
    private String password;
    private String nombre;
    private String descripcion;
    private String email;
    @JsonProperty("add_user")
    private String addUser;

    //    Rol Recurso
    @JsonProperty("id_rol")
    private Integer idRol;
    @JsonProperty("id_recurso")
    private Integer idRecurso;

    private Integer prefijo;
    private Integer correlativo;

    private String token;

    //    Reclamo

    @JsonProperty("id_tipologia")
    private Integer idTipologia;
    @JsonProperty("id_subtipologia")
    private Integer idSubTipologia;
    @JsonProperty("localidad_oficina")
    private String localidadOficina;
    private String glosa;
    private BigDecimal importe;
    private String moneda;
    @JsonProperty("moneda_extranjera")
    private String monedaExtranjera;
    @JsonProperty("tipo_documento")
    private String tipoDocumento;
    //    private String numeroDocumento;
    @JsonProperty("correlativo_documento")
    private Integer correlativoDocumento;
    @JsonProperty("extencion_documento")
    private String extencionDocumento;
    //    private String nombre;
    private String apellidos;
    @JsonProperty("direccion_1")
    private String direccion1;
    @JsonProperty("direccion_2")
    private String direccion2;
    @JsonProperty("telefono_fijo")
    private String telefonoFijo;
    @JsonProperty("telefono_celular")
    private String telefonoCelular;
//    private String email;

    @JsonProperty("tipo_reclamante")
    private String tipoReclamante;
    @JsonProperty("numero_testimonio")
    private Integer numeroTestimonio;
    @JsonProperty("representante_legal")
    private String representanteLegal;
    private String fecha;
    @JsonProperty("modo_respuesta")
    private String modoRespuesta;
    @JsonProperty("tipo_credito")
    private String tipoCredito;
    @JsonProperty("nombre_oficial")
    private String nombreOficial;

    @JsonProperty("numero_prestamo")
    private Integer numeroPrestamo;
    @JsonProperty("id_cargo")
    private Integer idCargo;
    private BigDecimal monto;

    public Request() {
    }

    public String requestUsuario(Request request) {
        String mensaje;
        if (request.getUsuario() != null && request.getPassword() != null && request.getNombre() != null && request.getDescripcion() != null &&
                request.getEmail() != null && request.getAddUser() != null && request.getEstado() != null && request.getIdRol() != null) {
            return null;
        } else {
            mensaje = (request.getUsuario() != null ? "" : "usuario ") +
                    (request.getPassword() != null ? "" : "password ") +
                    (request.getNombre() != null ? "" : "nombre ") +
                    (request.getDescripcion() != null ? "" : "descripcion ") +
                    (request.getEmail() != null ? "" : "email ") +
                    (request.getAddUser() != null ? "" : "add_user ") +
                    (request.getEstado() != null ? "" : "estado ") +
                    (request.getIdRol() != null ? "" : "id_rol");
            return mensaje;
        }
    }

    public String requestRolRecurso(Request request) {
        String mensaje;
        if (request.getIdRol() != null && request.getIdRecurso() != null && request.getUsuario() != null) {
            return null;
        } else {
            mensaje = (request.getIdRol() != null ? "" : "id_rol ") +
                    (request.getIdRecurso() != null ? "" : "id_recurso ") +
                    (request.getUsuario() != null ? "" : "usuario");
            return mensaje;
        }
    }

    public String requestCargoPrestamo(Request request) {
        String mensaje;
        if (request.getNumeroPrestamo() != null && request.getIdCargo() != null && request.getMonto() != null && request.getUsuario() != null) {
            return null;
        } else {
            mensaje = (request.getNumeroPrestamo() != null ? "" : "numero_prestamo ") +
                    (request.getIdCargo() != null ? "" : "id_cargo ") +
                    (request.getMonto() != null ? "" : "monto ") +
                    (request.getUsuario() != null ? "" : "usuario");
            return mensaje;
        }
    }

    public String requestSolicitarResetToken(Request request) {
        String mensaje;
        if (request.getUsuario() != null && request.getEmail() != null) {
            return null;
        } else {
            mensaje = (request.getUsuario() != null ? "" : "usuario ") +
                    (request.getEmail() != null ? "" : "email ");
            return mensaje;
        }
    }

    public String requestResetPassword(Request request) {
        String mensaje;
        if (request.getToken() != null && request.getEmail() != null && request.getPassword() != null) {
            return null;
        } else {
            mensaje = (request.getToken() != null ? "" : "token ") +
                    (request.getEmail() != null ? "" : "email ") +
                    (request.getPassword() != null ? "" : "password");
            return mensaje;
        }
    }

    public String requestReclamo(Request request) {
        String mensaje;
        if (request.getIdTipologia() != null &&
                request.getIdSubTipologia() != null &&
                request.getLocalidadOficina() != null &&
                request.getGlosa() != null &&
                request.getImporte() != null &&
                request.getMoneda() != null &&
                request.getMonedaExtranjera() != null &&
                request.getTipoDocumento() != null &&
                request.getNumeroDocumento() != null &&
                request.getExtencionDocumento() != null &&
                request.getNombre() != null &&
                request.getApellidos() != null &&
                request.getDireccion1() != null &&
                request.getTelefonoFijo() != null &&
                request.getTelefonoCelular() != null &&
                request.getEmail() != null &&

                request.getTipoReclamante() != null &&
                request.getNumeroTestimonio() != null &&
                request.getRepresentanteLegal() != null &&
                request.getFecha() != null &&
                request.getModoRespuesta() != null &&
                request.getTipoCredito() != null
        ) {

            return null;
        } else {
            mensaje = (request.getIdTipologia() != null ? "" : "id_tipologia ") +
                    (request.getIdSubTipologia() != null ? "" : "id_sub_tipologia ") +
                    (request.getLocalidadOficina() != null ? "" : "localidad_oficina ") +
                    (request.getGlosa() != null ? "" : "glosa ") +
                    (request.getImporte() != null ? "" : "importe ") +
                    (request.getMoneda() != null ? "" : "moneda ") +
                    (request.getMonedaExtranjera() != null ? "" : "moneda_extranjera ") +
                    (request.getTipoDocumento() != null ? "" : "tipo_documento ") +
                    (request.getNumeroDocumento() != null ? "" : "numero_documento ") +
                    (request.getExtencionDocumento() != null ? "" : "extencion_documento ") +
                    (request.getNombre() != null ? "" : "nombre ") +
                    (request.getApellidos() != null ? "" : "apellidos ") +
                    (request.getDireccion1() != null ? "" : "direccion_1 ") +
                    (request.getTelefonoFijo() != null ? "" : "telefono_fijo ") +
                    (request.getTelefonoCelular() != null ? "" : "telefono_celular ") +
                    (request.getEmail() != null ? "" : "email ") +
                    (request.getTipoReclamante() != null ? "" : "tipo_reclamante ") +
                    (request.getNumeroTestimonio() != null ? "" : "numero_testimonio ") +
                    (request.getRepresentanteLegal() != null ? "" : "representante_legal ") +
                    (request.getFecha() != null ? "" : "fecha ") +
                    (request.getModoRespuesta() != null ? "" : "modo_respuesta ") +
                    (request.getTipoCredito() != null ? "" : "tipo_credito ");
            return mensaje;
        }
    }
}
