package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.repository.PrestamoRepository;
import com.idepro.appbackendnetbank.repository.SegOperacionRepository;
import com.idepro.appbackendnetbank.service.*;
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


@RestController
@RequestMapping("/seguros")
public class SegurosController {

    @Autowired
    private ParticipanteService participanteService;
    @Autowired
    private DatosSolicitudService datosSolicitudService;
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private SegOperacionRepository segOperacionRepository;
    @Autowired
    private UsuarioNBService usuarioNBService;
    @Autowired
    private LogService logService;
    @Autowired
    private RolRecursoService rolRecursoService;

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('PARTICIPANTE POR ID PRESTAMO')")
    @GetMapping(value = "/participantePrestamo/{usuario}/{numeroPrestamo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarParticipantes(HttpServletRequest request, @PathVariable("usuario") String usuario, @PathVariable("numeroPrestamo") Integer numeroPrestamo) {

        ResponseEntity responseEntity;
        Response<Participante> response;
        Participante participante;

        try {
            UsuarioNB usuarioNB = usuarioNBService.obtUsuarioNBPorUsuarioYEstado(usuario, ConstantsUtil.PARAM_MARCA_BAJA_HABILITADO);
            if (usuarioNB != null) {
                participante = participanteService.listarParticipante(numeroPrestamo);
                if (participante != null) {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, participante);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                } else {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_PRESTAMO, ConstantsUtil.PARAM_ESTADO_NOK, null);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                }
            } else {
                response = new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_USUARIO_NB, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "PARTICIPANTE POR ID PRESTAMO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", usuario);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('CLIENTE POR NRO DOCUMENTO')")
    @GetMapping(value = "/cliente/{usuario}/{numeroDocumento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> obtCliente(HttpServletRequest request, @PathVariable("usuario") String usuario, @PathVariable("numeroDocumento") String numeroDocumento) {

        ResponseEntity responseEntity;
        ResponseList<Cliente> response;
        List<Cliente> clienteList;

        try {
            UsuarioNB usuarioNB = usuarioNBService.obtUsuarioNBPorUsuarioYEstado(usuario, ConstantsUtil.PARAM_MARCA_BAJA_HABILITADO);
            if (usuarioNB != null) {
                clienteList = participanteService.ObtTitularByNumeroDocumento(numeroDocumento);
                if (clienteList.size() > 0) {
                    response = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, clienteList);
                    responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.OK);
                } else {
                    response = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_CLIENTE, ConstantsUtil.PARAM_ESTADO_NOK, null);
                    responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.OK);
                }
            } else {
                response = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_USUARIO_NB, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseList<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "CLIENTE POR NRO DOCUMENTO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", usuario);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('SOLICITUD POR ID PRESTAMO')")
    @GetMapping(value = "/datosPrestamo/{usuario}/{numeroPrestamo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> datosPrestamo(HttpServletRequest request, @PathVariable("usuario") String usuario, @PathVariable("numeroPrestamo") Integer numeroPrestamo) {

        ResponseEntity responseEntity;
        Response<DatosSolicitud> response;
        DatosSolicitud datosSolicitud;

        try {
            UsuarioNB usuarioNB = usuarioNBService.obtUsuarioNBPorUsuarioYEstado(usuario, ConstantsUtil.PARAM_MARCA_BAJA_HABILITADO);
            if (usuarioNB != null) {
                datosSolicitud = datosSolicitudService.listaDatosSolicitud(numeroPrestamo);
                if (datosSolicitud != null) {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, datosSolicitud);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                } else {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_PRESTAMO, ConstantsUtil.PARAM_ESTADO_NOK, null);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                }
            } else {
                response = new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_USUARIO_NB, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "SOLICITUD POR ID PRESTAMO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", usuario);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('OPERACION POR ID PRESTAMO')")
    @GetMapping(value = "/datosOperacion/{usuario}/{numeroPrestamo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> datosOperacion(HttpServletRequest request, @PathVariable("usuario") String usuario, @PathVariable("numeroPrestamo") Integer numeroPrestamo) {

        ResponseEntity responseEntity;
        Response<DatosOperacion> response;
        DatosOperacion datosOperacion;

        try {
            UsuarioNB usuarioNB = usuarioNBService.obtUsuarioNBPorUsuarioYEstado(usuario, ConstantsUtil.PARAM_MARCA_BAJA_HABILITADO);
            if (usuarioNB != null) {
                datosOperacion = datosSolicitudService.listaDatosOperacion(numeroPrestamo);
                if (datosOperacion != null) {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, datosOperacion);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                } else {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_PRESTAMO, ConstantsUtil.PARAM_ESTADO_NOK, null);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                }
            } else {
                response = new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_USUARIO_NB, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "OPERACION POR ID PRESTAMO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", usuario);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('OPERACION POR NRO DOCUMENTO')")
    @GetMapping(value = "/datosOperacionPorNumeroDocumento/{usuario}/{numeroDocumento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseList> datosOperacionPorNmeroDocumento(HttpServletRequest request, @PathVariable("usuario") String usuario, @PathVariable("numeroDocumento") String numeroDocumento) {

        ResponseEntity responseEntity;
        ResponseList<DatosHistoricoPrestamo> response;
        List<DatosHistoricoPrestamo> datosHistoricoPrestamoList = new ArrayList<>();
        DatosHistoricoPrestamo datosHistoricoPrestamo;

        try {
            UsuarioNB usuarioNB = usuarioNBService.obtUsuarioNBPorUsuarioYEstado(usuario, ConstantsUtil.PARAM_MARCA_BAJA_HABILITADO);
            if (usuarioNB != null) {
                for (Prestamo prestamo : prestamoRepository.listByNumeroPrestamo(numeroDocumento)) {
                    datosHistoricoPrestamo = new DatosHistoricoPrestamo();
                    datosHistoricoPrestamo.setDatosOperacion(datosSolicitudService.listaDatosOperacion(prestamo.getIdPrestamo()));
                    datosHistoricoPrestamo.setParticipante(participanteService.listarParticipante(prestamo.getIdPrestamo()));
                    datosHistoricoPrestamoList.add(datosHistoricoPrestamo);
                }
                if (datosHistoricoPrestamoList != null) {
                    response = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, datosHistoricoPrestamoList);
                    responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.OK);
                } else {
                    response = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_CLIENTE, ConstantsUtil.PARAM_ESTADO_NOK, null);
                    responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.OK);
                }
            } else {
                response = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_USUARIO_NB, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseList<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<ResponseList>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "OPERACION POR NRO DOCUMENTO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", usuario);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

   // @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('SEGURO MI VIDA POR FECHA')")
    @GetMapping(value = "/miVidaguroPorFechas/{fechaInicial}/{fechaFinal}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseList> miVidaSeguroPorFechas(HttpServletRequest request, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {

        ResponseEntity responseEntity;
        List<SegMiVida> segMiVidaArrayList = new ArrayList<>();
        ResponseList<SegMiVida> responseList;

            try {
                segMiVidaArrayList = segOperacionRepository.findPorFechas(fechaInicial, fechaFinal);
                if (segMiVidaArrayList.size() > 0) {
                    responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, segMiVidaArrayList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "SEGURO MI VIDA POR FECHA", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }
}
