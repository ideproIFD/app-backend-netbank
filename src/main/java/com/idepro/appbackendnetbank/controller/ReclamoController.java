package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.service.LogService;
import com.idepro.appbackendnetbank.service.ReclamoService;
import com.idepro.appbackendnetbank.service.RolRecursoService;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 17/11/2021.
 */
@RestController
@RequestMapping("/reclamos")
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;
    @Autowired
    private LogService logService;
    @Autowired
    private RolRecursoService rolRecursoService;

    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public String handleHttpMediaTypeNotAcceptableException() {
        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('REGISTRAR RECLAMO')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Entity> registrar(HttpServletRequest request, @RequestBody Request requestInput) {

        String requestValidate = requestInput.requestReclamo(requestInput);
        ResponseEntity responseEntity;
        Response<Reclamo> response;

        if (requestValidate == null) {
            Reclamo reclamoRequest = new Reclamo();
            reclamoRequest.setIdTipologia(requestInput.getIdTipologia());
            reclamoRequest.setIdSubTipologia(requestInput.getIdSubTipologia());
            reclamoRequest.setLocalidadOficina(requestInput.getLocalidadOficina());
            reclamoRequest.setGlosa(requestInput.getGlosa());
            reclamoRequest.setImporte(requestInput.getImporte());
            reclamoRequest.setMoneda(requestInput.getMoneda());
            reclamoRequest.setMonedaExtranjera(requestInput.getMonedaExtranjera());
            reclamoRequest.setTipoDocumento(requestInput.getTipoDocumento());
            reclamoRequest.setNumeroDocumento(requestInput.getNumeroDocumento());
            reclamoRequest.setExtencionDocumento(requestInput.getExtencionDocumento());
            reclamoRequest.setNombre(requestInput.getNombre());
            reclamoRequest.setApellidos(requestInput.getApellidos());
            reclamoRequest.setDireccion1(requestInput.getDireccion1());
            reclamoRequest.setDireccion2(requestInput.getDireccion2());
            reclamoRequest.setTelefonoFijo(requestInput.getTelefonoFijo());
            reclamoRequest.setTelefonoCelular(requestInput.getTelefonoCelular());
            reclamoRequest.setEmail(requestInput.getEmail());

            reclamoRequest.setTipoReclamante(requestInput.getTipoReclamante());
            if (ConstantsUtil.PARAM_PERSONA_NATURAL.equals(reclamoRequest.getTipoReclamante())) {
                reclamoRequest.setNumeroTestimonio(null);
                reclamoRequest.setRepresentanteLegal(null);
            } else {
                reclamoRequest.setNumeroTestimonio(requestInput.getNumeroTestimonio());
                reclamoRequest.setRepresentanteLegal(requestInput.getRepresentanteLegal());
            }
            reclamoRequest.setFecha(requestInput.getFecha());
            reclamoRequest.setModoRespuesta(requestInput.getModoRespuesta());
            reclamoRequest.setTipoCredito(requestInput.getTipoCredito());
            reclamoRequest.setNombreOficial(requestInput.getNombreOficial());

            try {
                Reclamo reclamoResponse = reclamoService.save(reclamoRequest);
                if (reclamoResponse != null) {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, reclamoResponse);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                } else {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_USUARIO_NB, ConstantsUtil.PARAM_ESTADO_NOK, null);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
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

        Log log = new Log(rolRecursoService.obtUsuario(), "REGISTRAR RECLAMO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI() + " - BODY:" + requestInput, response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR RECLAMO POR EMAIL')")
    @GetMapping(value = "/email/{email:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPorEmail(HttpServletRequest request, @PathVariable("email") String email) {

        ResponseEntity responseEntity;
        ResponseList<Reclamo> responseList;
        List<Reclamo> reclamoList = new ArrayList<>();

        try {
            reclamoList = reclamoService.listReclamoByEmail(email);
            if (reclamoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, reclamoList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR RECLAMO POR EMAIL", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR RECLAMO POR NUMERO DOCUMENTO')")
    @GetMapping(value = "/{numeroDocumento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPorNumeroDocumento(HttpServletRequest request, @PathVariable("numeroDocumento") String numeroDocumento) {

        ResponseEntity responseEntity;
        ResponseList<Reclamo> responseList;
        List<Reclamo> reclamoList = new ArrayList<>();

        try {
            reclamoList = reclamoService.listReclamoByNumeroDocumento(numeroDocumento);
            if (reclamoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, reclamoList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR RECLAMO POR NUMERO DOCUMENTO", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

}
