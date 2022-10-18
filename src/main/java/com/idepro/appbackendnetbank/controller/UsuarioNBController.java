package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.Log;
import com.idepro.appbackendnetbank.model.Response;
import com.idepro.appbackendnetbank.model.UsuarioNB;
import com.idepro.appbackendnetbank.service.LogService;
import com.idepro.appbackendnetbank.service.RolRecursoService;
import com.idepro.appbackendnetbank.service.UsuarioNBService;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
@RequestMapping("/usuariosNB")
public class UsuarioNBController {
    @Autowired
    private UsuarioNBService usuarioNBService;
    @Autowired
    private LogService logService;
    @Autowired
    private RolRecursoService rolRecursoService;

    //    @PreAuthorize("hasAuthority('ADMIN')")
    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BUSCA USUARIO HABILITADO')")
    @GetMapping(value = "/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> buscaUsuarioNbHabilitado(HttpServletRequest request, @PathVariable("usuario") String usuario){

        ResponseEntity responseEntity;
        Response<UsuarioNB> response;
        UsuarioNB usuarioNB;

        try {
            usuarioNB = usuarioNBService.obtUsuarioNBPorUsuarioYEstado(usuario.toUpperCase(), ConstantsUtil.PARAM_MARCA_BAJA_HABILITADO);
            if (usuarioNB != null) {
                response = new Response(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, usuarioNB);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
            } else {
                response = new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_USUARIO_NB, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Log log = new Log(rolRecursoService.obtUsuario(), "BUSCA USUARIO HABILITADO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", usuario);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BUSCA USUARIO POR ESTADO')")
    @GetMapping(value = "/{usuario}/{estado}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> buscaUsuarioNbPorEstado(@PathVariable("usuario") String usuario, @PathVariable("estado") String estado) {

        ResponseEntity responseEntity;
        Response<UsuarioNB> response;
        UsuarioNB usuarioNB;

        try {
            usuarioNB = usuarioNBService.obtUsuarioNBPorUsuarioYEstado(usuario.toUpperCase(), estado);
            if (usuarioNB != null) {
                response = new Response(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, usuarioNB);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
            } else {
                response = new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_USUARIO_NB, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
