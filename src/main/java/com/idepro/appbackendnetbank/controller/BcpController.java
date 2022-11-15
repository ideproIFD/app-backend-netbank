package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.service.*;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.idepro.appbackendnetbank.util.ConstantsUtil.*;

@RestController
@RequestMapping("/bcp")
public class BcpController {

    @Autowired
    private BcpClienteService bcpClienteService;

    @Autowired
    private BcpConsultaService bcpConsultaService;

    @Autowired
    private RolRecursoService rolRecursoService;

    @Autowired
    private LogService logService;

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BCP CONSULTA CUOTA')")
    @PostMapping(value = "/consulta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Entity> listar(HttpServletRequest request, @RequestBody BcpRequest requestInput) {

        ResponseEntity responseEntity;
        Response<BcpConsulta> response;

        String requestValidate = requestInput.requestConsulta(requestInput);
        if (requestValidate == null) {
            try {
                BcpConsulta bcpConsulta = bcpConsultaService.findByIdPrestamoCodServicio( Integer.parseInt(requestInput.getCodigoBusqueda()),requestInput.getCodServicio());
                if (bcpConsulta != null) {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, bcpConsulta);
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
        } else {
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR_REQUEST(requestValidate), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "BCP CONSULTA CUOTA", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BCP PAGO CUOTA')")
    @PostMapping(value = "/pago", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Entity> pago(HttpServletRequest request, @RequestBody BcpRequest requestInput) {

        ResponseEntity responseEntity;
        Response<BcpPago> response;

        String requestValidate = requestInput.requestConsulta(requestInput);
        if (requestValidate == null) {
            try {
                BcpPago bcpPagoCredito = bcpConsultaService.findByIdPagoCodServicio(requestInput);
                if (bcpPagoCredito != null) {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, bcpPagoCredito);
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
        } else {
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR_REQUEST(requestValidate), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "BCP PAGO CUOTA", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BCP REVERSION PAGO')")
    @PostMapping(value = "/reversion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Entity> reversion(HttpServletRequest request, @RequestBody BcpRequest requestInput) {
        ResponseEntity responseEntity;
        Response<BcpReversion> response;

        String requestValidate = requestInput.requestConsulta(requestInput);
        if (requestValidate == null) {
            try {
                BcpReversion bcpReversionPagoCredito = bcpConsultaService.findByIdReversionCodServicio(requestInput);
                if (bcpReversionPagoCredito != null) {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, bcpReversionPagoCredito);
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
        } else {
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR_REQUEST(requestValidate), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "BCP REVERSION PAGO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

   // @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BCP ESTADO PAGO')")
    @PostMapping(value = "/estadoTransaccion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Entity> estadoTransaccion(HttpServletRequest request, @RequestBody BcpRequest requestInput) {
        ResponseEntity responseEntity;
        Response<BcpEstadoTransaccion> response;
        BcpEstadoTransaccion bcpEstadoTransaccion = new BcpEstadoTransaccion();

        String requestValidate = requestInput.requestConsulta(requestInput);
        if (requestValidate == null) {
            try {
                bcpEstadoTransaccion = bcpConsultaService.findByIdEstadoTransaccion(requestInput.getCodigoBusqueda(), requestInput.getFechaPago());
                if (bcpEstadoTransaccion != null) {
                    bcpEstadoTransaccion.setCodError(COD_ERROR_1);
                    bcpEstadoTransaccion.setDescripcion(DESCRIPCION_1);
                    //bcpEstadoTransaccion.setIdTransaccionEmpresa(requestInput.getIdTransaccion());
                    String fecha = bcpEstadoTransaccion.getFecha();
                    String[] parts = fecha.split("-");
                    String anio = parts[0];
                    String mes = parts[1];
                    String dia = parts[2];
                    String fechaM = dia + "/" + mes + "/" + anio;
                    bcpEstadoTransaccion.setFecha(fechaM);
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, bcpEstadoTransaccion);
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
        } else {
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR_REQUEST(requestValidate), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "BCP ESTADO PAGO", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

   // @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BCP HISTORIAL PAGO')")
    @PostMapping(value = "/historialTransacciones", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Entity> historialTransacciones(HttpServletRequest request, @RequestBody BcpRequest requestInput) {
        ResponseEntity responseEntity;
        ResponseList<BcpEstadoTransaccion> responseList;
        List<BcpEstadoTransaccion> bcpEstadoTransaccionList = new ArrayList<>();

        String requestValidate = requestInput.requestConsulta(requestInput);
        if (requestValidate == null) {
            try {
                bcpEstadoTransaccionList = null; //bcpConsultaService.findByIdHistorialTransaccion(requestInput.getFechaInicio(), requestInput.getFechaFinal(),requestInput.getIdTransaccion());
                if (bcpEstadoTransaccionList.size() > 0) {
                    responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, bcpEstadoTransaccionList);
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
        } else {
            responseList = new ResponseList<>(ConstantsUtil.MENSAJE_ERROR_REQUEST(requestValidate), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.BAD_REQUEST);
        }
        Log log = new Log(rolRecursoService.obtUsuario(), "BCP HISTORIAL PAGO", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
