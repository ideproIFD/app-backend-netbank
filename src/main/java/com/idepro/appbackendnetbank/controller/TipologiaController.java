package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.service.LogService;
import com.idepro.appbackendnetbank.service.RolRecursoService;
import com.idepro.appbackendnetbank.service.TipologiaService;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/11/2021.
 */
@RestController
@RequestMapping("/tipologias")
public class TipologiaController {

    @Autowired
    private TipologiaService tipologiaService;
    @Autowired
    private LogService logService;
    @Autowired
    private RolRecursoService rolRecursoService;

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR TIPOLOGIA')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listar(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<Tipologia> responseList;
        List<Tipologia> tipologiaList = new ArrayList<>();

        try {
            tipologiaList = tipologiaService.listAll();
            if (tipologiaList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, tipologiaList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR TIPOLOGIA", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR TIPOLOGIA POR ID TIPOLOGIA')")
    @GetMapping(value = "/{idTipologia}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPorIdTipologia(HttpServletRequest request, @PathVariable("idTipologia") Integer idTipologia) {

        ResponseEntity responseEntity;
        ResponseList<Tipologia> responseList;
        List<Tipologia> tipologiaList = new ArrayList<>();

        try {
            tipologiaList = tipologiaService.listByIdTipologia(idTipologia);
            if (tipologiaList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, tipologiaList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR TIPOLOGIA POR ID TIPOLOGIA", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BUSCA TIPOLOGIA POR ID TIPOLOGIA Y ID SUBTIPOLOGIA')")
    @GetMapping(value = "/{idTipologia}/{idSubTipologia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPorPrefijoPorCorrelativo(HttpServletRequest request, @PathVariable("idTipologia") Integer idTipologia, @PathVariable("idSubTipologia") Integer idSubTipologia) {

        ResponseEntity responseEntity;
        Response<Tipologia> response;
        Tipologia tipologia;

        try {
            tipologia = tipologiaService.findByIdTipologiaByIdSubTipologia(idTipologia, idSubTipologia);
            if (tipologia != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, tipologia);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "BUSCA TIPOLOGIA POR ID TIPOLOGIA Y ID SUBTIPOLOGIA", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }
}
