package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.service.DocumentoOrigenService;
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
@RequestMapping("/documentosOrigen")
public class DocumentoOrigenController {

    @Autowired
    private DocumentoOrigenService documentoOrigenService;
    @Autowired
    private LogService logService;
    @Autowired
    private RolRecursoService rolRecursoService;

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR DOCUMENTOS ORIGEN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listar(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<DocumentoOrigen> responseList;
        List<DocumentoOrigen> documentoOrigenList = new ArrayList<>();

        try {
            documentoOrigenList = documentoOrigenService.listAll();
            if (documentoOrigenList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, documentoOrigenList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR DOCUMENTOS ORIGEN", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }
}
