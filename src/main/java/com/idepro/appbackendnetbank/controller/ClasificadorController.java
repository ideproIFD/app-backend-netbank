package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.service.ClasificadorService;
import com.idepro.appbackendnetbank.service.LogService;
import com.idepro.appbackendnetbank.service.RolRecursoService;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 17/5/2021.
 */
@RestController
@RequestMapping("/clasificadores")
public class ClasificadorController {

    @Autowired
    private ClasificadorService clasificadorService;
    @Autowired
    private LogService logService;
    @Autowired
    private RolRecursoService rolRecursoService;

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR CLASIFICADOR POR TABLA')")
    @GetMapping(value = "/{tabla}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listar(HttpServletRequest request, @PathVariable("tabla") String tabla) {

        ResponseEntity responseEntity;
        ResponseList<Clasificador> responseList;
        List<Clasificador> clasificadorList = new ArrayList<>();

        try {
            clasificadorList = clasificadorService.listAll(tabla.toUpperCase());
            if (clasificadorList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, clasificadorList);
                responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.OK);
            } else {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseList = new ResponseList<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR CLASIFICADOR POR TABLA", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BUSCA CLASIFICADOR POR TABLA Y PREFIJO')")
    @GetMapping(value = "/{tabla}/{prefijo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPorPrefijo(HttpServletRequest request, @PathVariable("tabla") String tabla, @PathVariable("prefijo") Integer prefijo) {

        ResponseEntity responseEntity;
        ResponseList<Clasificador> responseList;
        List<Clasificador> clasificadorList = new ArrayList<>();

        try {
            clasificadorList = clasificadorService.listByPrefijo(prefijo, tabla.toUpperCase());
            if (clasificadorList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, clasificadorList);
                responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.OK);
            } else {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseList = new ResponseList<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "BUSCA CLASIFICADOR POR TABLA Y PREFIJO", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BUSCA CLASIFICADOR POR TABLA, PREFIJO Y CORRELATIVO')")
    @GetMapping(value = "/{tabla}/{prefijo}/{correlativo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPorPrefijoPorCorrelativo(HttpServletRequest request, @PathVariable("tabla") String tabla, @PathVariable("prefijo") Integer prefijo, @PathVariable("correlativo") Integer correlativo) {

        ResponseEntity responseEntity;
        Response<Clasificador> response;
        Clasificador clasificador;

        try {
            clasificador = clasificadorService.findByPrefijoByCorrelativo(prefijo, correlativo, tabla.toUpperCase());
            if (clasificador != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, clasificador);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
            } else {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "BUSCA CLASIFICADOR POR TABLA, PREFIJO Y CORRELATIVO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }
}
