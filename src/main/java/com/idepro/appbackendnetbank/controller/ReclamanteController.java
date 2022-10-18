package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.repository.ReclamanteRepository;
import com.idepro.appbackendnetbank.service.LogService;
import com.idepro.appbackendnetbank.service.ReclamoService;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 15/11/2021.
 */
@RestController
@RequestMapping("/reclamantes")
public class ReclamanteController {

    @Autowired
    private LogService logService;
    @Autowired
    private RolRecursoService rolRecursoService;
    @Autowired
    private ReclamanteRepository reclamanteRepository;
    @Autowired
    private ReclamoService reclamoService;

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR RECLAMANTE POR NUMERO DE DOCUMENTO')")
    @GetMapping(value = "/{numeroDocumento}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPorNumeroDocumento(HttpServletRequest request, @PathVariable("numeroDocumento") String numeroDocumento) {

        ResponseEntity responseEntity;
        ResponseList<Reclamante> responseList;
        List<Reclamante> reclamanteList = new ArrayList<>();

        try {
            reclamanteList = reclamanteRepository.listByNumeroDocumento(numeroDocumento);
            if (reclamanteList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, reclamanteList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR RECLAMANTE POR NUMERO DE DOCUMENTO", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }
}
