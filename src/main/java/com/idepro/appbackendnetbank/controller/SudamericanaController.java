package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.repository.SudCargoPrestamoRepository;
import com.idepro.appbackendnetbank.service.*;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 23/5/2022.
 */
@RestController
@RequestMapping("/sudamericana")
public class SudamericanaController {

    @Autowired
    private LogService logService;
    @Autowired
    private RolRecursoService rolRecursoService;
    @Autowired
    private SudClienteService sudClienteService;
    @Autowired
    private SudCargoPrestamoService sudCargoPrestamoService;
    @Autowired
    private SudCargoPrestamoRepository sudCargoPrestamoRepository;

//    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR PRESTAMO POR NUMERO DOCUMENTO')")
    @GetMapping(value = "/cliente/codigoCliente/{codigoCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarClientePorCodigoCliente(HttpServletRequest request, @PathVariable("codigoCliente") String codigoCliente) {

        ResponseEntity responseEntity;
        Response<SudCliente> response;
        SudCliente sudCliente = new SudCliente();

        try {
            sudCliente = sudClienteService.findClienteByCodigoCliente(codigoCliente);
            if (sudCliente != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, sudCliente);
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
//        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR PRESTAMO POR NUMERO DOCUMENTO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
//        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @GetMapping(value = "/cliente/numeroDocumento/{numeroDocumento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarClientePorNumeroDocumento(HttpServletRequest request, @PathVariable("numeroDocumento") String numeroDocumento) {

        ResponseEntity responseEntity;
        ResponseList<SudCliente> response;
        List<SudCliente> clienteList = new ArrayList<>();

        try {
            clienteList = sudClienteService.listByNumeroDocumento(numeroDocumento);
            if (clienteList != null) {
                response = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, clienteList);
                responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.OK);
            } else {
                response = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseList<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR PRESTAMO POR NUMERO DOCUMENTO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
//        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @GetMapping(value = "/cargoPrestamo/{numeroDocumento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarCargoPorNumeroDocumento(HttpServletRequest request, @PathVariable("numeroDocumento") Integer numeroDocumento) {

        ResponseEntity responseEntity;
        ResponseList<SudCargoPrestamo> response;
        List<SudCargoPrestamo> cargoPrestamoList = new ArrayList<>();

        try {
            cargoPrestamoList = sudCargoPrestamoService.listCargoByNumeroPrestamo(numeroDocumento);
            if (cargoPrestamoList != null) {
                response = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, cargoPrestamoList);
                responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.OK);
            } else {
                response = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseList<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR PRESTAMO POR NUMERO DOCUMENTO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
//        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    //    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('REGISTRAR ROL RECURSO')")
    @PostMapping(value = "/cargoPrestamo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Entity> registrar(@RequestBody Request request) {

        String requestValidate = request.requestCargoPrestamo(request);
        ResponseEntity responseEntity;
        Response<SudCargoPrestamo> response;
        SudCargoPrestamo cargoPrestamo;

        if (requestValidate == null) {
            try {
                cargoPrestamo = sudCargoPrestamoRepository.findCargoByNumeroPrestamoByIdCargo(request.getNumeroPrestamo(), request.getIdCargo());
                if (cargoPrestamo == null) {
                    sudCargoPrestamoRepository.saveCargoPrestamo(request.getNumeroPrestamo(), request.getIdCargo(), request.getMonto(), request.getUsuario());
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, sudCargoPrestamoRepository.findCargoByNumeroPrestamoByIdCargo(request.getNumeroPrestamo(), request.getIdCargo()));
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                } else {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_YA_EXISTE_EL_REGISTRO, ConstantsUtil.PARAM_ESTADO_NOK, cargoPrestamo);
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
}
