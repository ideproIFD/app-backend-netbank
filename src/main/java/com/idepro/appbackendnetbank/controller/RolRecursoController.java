package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.repository.RolRecursoRepository;
import com.idepro.appbackendnetbank.service.RolRecursoService;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 27/5/2021.
 */
@RestController
@RequestMapping("/rolesRecursos")
public class RolRecursoController {

    @Autowired
    private RolRecursoService rolRecursoService;
    @Autowired
    private RolRecursoRepository rolRecursoRepository;

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR ROL RECURSO')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listar() {

        ResponseEntity responseEntity;
        ResponseList<RolRecurso> responseList;
        List<RolRecurso> rolRecursoList = new ArrayList<>();

        try {
            rolRecursoList = rolRecursoRepository.listAll();
            if (rolRecursoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, rolRecursoList);
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
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BUSCA ROL RECURSO POR ROL')")
    @GetMapping(value = "/{idRol}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPorRol(@PathVariable("idRol") Integer idRol) {

        ResponseEntity responseEntity;
        ResponseList<RolRecurso> responseList;
        List<RolRecurso> rolRecursoList = new ArrayList<>();

        try {
            rolRecursoList = rolRecursoRepository.listByIdRol(idRol);
            if (rolRecursoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, rolRecursoList);
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
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BUSCA ROL RECURSO POR ROL Y RECURSO')")
    @GetMapping(value = "/{idRol}/{idRecurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPorPrefijoPorCorrelativo(@PathVariable("idRol") Integer idRol, @PathVariable("idRecurso") Integer idRecurso) {

        ResponseEntity responseEntity;
        Response<RolRecurso> response;
        RolRecurso rolRecurso;

        try {
            rolRecurso = rolRecursoRepository.findByIdRolByIdRecurso(idRol, idRecurso);
            if (rolRecurso != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, rolRecurso);
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
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('REGISTRAR ROL RECURSO')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Entity> registrar(@RequestBody Request request) {

        String requestValidate = request.requestRolRecurso(request);
        ResponseEntity responseEntity;
        Response<RolRecurso> response;
        RolRecurso rolRecurso;

        if (requestValidate == null) {
            try {
                rolRecurso = rolRecursoRepository.findByIdRolByIdRecurso(request.getIdRol(), request.getIdRecurso());
                if (rolRecurso == null) {
                    rolRecursoRepository.saveRolRecurso(request.getIdRol(), request.getIdRecurso(), request.getUsuario());
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, rolRecursoRepository.findByIdRolByIdRecurso(request.getIdRol(), request.getIdRecurso()));
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                } else {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_YA_EXISTE_EL_REGISTRO, ConstantsUtil.PARAM_ESTADO_NOK, rolRecurso);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.FOUND);
                }
            } catch (Exception e) {
                e.printStackTrace();
                response = new Response<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR_REQUEST(requestValidate), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BORRAR ROL RECURSO')")
    @DeleteMapping(value = "/{idRol}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> eliminar(@PathVariable Integer idRol) {

        ResponseEntity responseEntity;
        ResponseList<RolRecurso> responseList;
        List<RolRecurso> rolRecursoList = new ArrayList<>();

        try {
            rolRecursoList = rolRecursoRepository.listByIdRol(idRol);
            if (rolRecursoList.size() > 0) {
                rolRecursoRepository.deleteRolRecursoByIdRol(idRol);
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, rolRecursoList);
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
        return responseEntity;
    }
}
