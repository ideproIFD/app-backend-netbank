package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.service.DocumentoOrigenService;
import com.idepro.appbackendnetbank.service.LocalidadReclamoService;
import com.idepro.appbackendnetbank.service.LogService;
import com.idepro.appbackendnetbank.service.RolRecursoService;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 9/11/2021.
 */
@RestController
@RequestMapping("/localidadReclamos")
public class LocalidadReclamoController {

    @Autowired
    private LocalidadReclamoService localidadReclamoService;
    @Autowired
    private LogService logService;
    @Autowired
    private RolRecursoService rolRecursoService;

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR LOCALIDAD RECLAMOS')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listar(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<LocalidadReclamo> responseList;
        List<LocalidadReclamo> localidadReclamoList = new ArrayList<>();

        try {
            localidadReclamoList = localidadReclamoService.listAll();
            if (localidadReclamoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, localidadReclamoList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR LOCALIDAD RECLAMOS", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }
}
