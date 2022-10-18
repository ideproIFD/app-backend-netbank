package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.Log;
import com.idepro.appbackendnetbank.model.ParametroDiario;
import com.idepro.appbackendnetbank.model.Response;
import com.idepro.appbackendnetbank.model.UsuarioNB;
import com.idepro.appbackendnetbank.service.LogService;
import com.idepro.appbackendnetbank.service.ParametroDiarioService;
import com.idepro.appbackendnetbank.service.RolRecursoService;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 26/7/2022.
 */
@RestController
@RequestMapping("/parametrosDiarios")
public class ParametroDiarioController {

    @Autowired
    private LogService logService;
    @Autowired
    private RolRecursoService rolRecursoService;
    @Autowired
    private ParametroDiarioService parametroDiarioService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarParametroDiario(HttpServletRequest request){

        ResponseEntity responseEntity;
        Response<ParametroDiario> response;
        ParametroDiario parametroDiario;

        try {
            parametroDiario = parametroDiarioService.listParametroDiario();
            if (parametroDiario != null) {
                response = new Response(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, parametroDiario);
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

//        Log log = new Log(rolRecursoService.obtUsuario(), "BUSCA USUARIO HABILITADO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", usuario);
//        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }
}
