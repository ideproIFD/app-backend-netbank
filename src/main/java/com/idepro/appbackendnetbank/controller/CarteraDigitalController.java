package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.repository.CdClienteRepository;
import com.idepro.appbackendnetbank.service.*;
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
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 28/3/2022.
 */
@RestController
@RequestMapping("/carteraDigital")
public class CarteraDigitalController {

    @Autowired
    private CdAgenciaService cdAgenciaService;
    @Autowired
    private CdZonaService cdZonaService;
    @Autowired
    private CdGestorService cdGestorService;
    @Autowired
    private CdPerfilService cdPerfilService;
    @Autowired
    private CdClienteService cdClienteService;
    @Autowired
    private CdFiadorAsignadoService cdFiadorAsignadoService;
    @Autowired
    private LogService logService;
    @Autowired
    private RolRecursoService rolRecursoService;
    @Autowired
    private CdCreditoService cdCreditoService;
    @Autowired
    private CdLineaCreditoService lineaCreditoService;
    @Autowired
    private CdCreditoAsignadoService creditoAsignadoService;
    @Autowired
    private CdHistorialPagoService historialPagoService;
    @Autowired
    private CdGarantiaService cdGarantiaService;
    @Autowired
    private CdGarantiaAsignadoService cdGarantiaAsignadoService;

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('AGENCIA')")
    @GetMapping(value = "/agencia", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarAgencias(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdAgencia> responseList;
        List<CdAgencia> agenciaList = new ArrayList<>();

        try {
            agenciaList = cdAgenciaService.listAll();
            if (agenciaList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, agenciaList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR AGENCIAS", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('AGENCIA')")
    @GetMapping(value = "/agencia/{idAgencia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarAgenciaPorIdAgencia(HttpServletRequest request, @PathVariable("idAgencia") Integer idAgencia) {

        ResponseEntity responseEntity;
        Response<CdAgencia> response;
        CdAgencia agencia = new CdAgencia();

        try {
            agencia = cdAgenciaService.findByIdAgencia(idAgencia);
            if (agencia != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, agencia);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR AGENCIA POR ID", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('ZONA')")
    @GetMapping(value = "/zona", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarZonas(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdZona> responseList;
        List<CdZona> zonaList = new ArrayList<>();

        try {
            zonaList = cdZonaService.listAll();
            if (zonaList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, zonaList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR ZONAS", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }
    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('ZONA')")
    @GetMapping(value = "/zona/{idZona}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarZonaPorIdZona(HttpServletRequest request, @PathVariable("idZona") Integer idZona) {

        ResponseEntity responseEntity;
        Response<CdZona> response;
        CdZona zona = new CdZona();

        try {
            zona = cdZonaService.findByIdZona(idZona);
            if (zona != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, zona);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR ZONA POR ID", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('GESTOR')")
    @GetMapping(value = "/gestor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarGestores(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdGestor> responseList;
        List<CdGestor> gestorList = new ArrayList<>();

        try {
            gestorList = cdGestorService.listAll();
            if (gestorList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, gestorList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR GESTORES", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('GESTOR')")
    @GetMapping(value = "/perfil", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPerfiles(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdPerfil> responseList;
        List<CdPerfil> perfilList = new ArrayList<>();

        try {
            perfilList = cdPerfilService.listAll();
            if (perfilList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, perfilList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR PERFILES", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('GESTOR')")
    @GetMapping(value = "/gestor/{idGestor}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarGestorPorIdGestor(HttpServletRequest request, @PathVariable("idGestor") Integer idGestor) {

        ResponseEntity responseEntity;
        Response<CdGestor> response;
        CdGestor gestor = new CdGestor();

        try {
            gestor = cdGestorService.findByIdGestor(idGestor);
            if (gestor != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, gestor);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR GESTOR POR ID", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('CREDITO')")
    @GetMapping(value = "/credito", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarCreditos(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdCredito> responseList;
        List<CdCredito> creditoList = new ArrayList<>();

        try {
            creditoList = cdCreditoService.listAll();
            if (creditoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, creditoList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR CREDITOS", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('CREDITO')")
    @GetMapping(value = "/credito/{idCredito}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarCreditoPorIdCredito(HttpServletRequest request, @PathVariable("idCredito") Integer idCredito) {

        ResponseEntity responseEntity;
        Response<CdCredito> response;
        CdCredito credito = new CdCredito();

        try {
            credito = cdCreditoService.findByIdCredito(idCredito);
            if (credito != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, credito);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR CREDITO POR ID", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LINEA DE CREDITO')")
    @GetMapping(value = "/lineaCredito", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarLineasCreditos(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdLineaCredito> responseList;
        List<CdLineaCredito> lineaCreditoList = new ArrayList<>();

        try {
            lineaCreditoList = lineaCreditoService.listAll();
            if (lineaCreditoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, lineaCreditoList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR LINEAS DE CREDITOS", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LINEA DE CREDITO')")
    @GetMapping(value = "/credito/{idLineaCredito}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarLineaCreditoPorIdLineaCredito(HttpServletRequest request, @PathVariable("idLineaCredito") Integer idLineaCredito) {

        ResponseEntity responseEntity;
        Response<CdLineaCredito> response;
        CdLineaCredito lineaCredito = new CdLineaCredito();

        try {
            lineaCredito = lineaCreditoService.findByIdLineaCredito(idLineaCredito);
            if (lineaCredito != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, lineaCredito);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR LINEA DE CREDITO POR ID", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('CREDITO ASIGNADO')")
    @GetMapping(value = "/creditoAsignado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarCreditosAsignados(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdCreditoAsignado> responseList;
        List<CdCreditoAsignado> creditoAsignadoList = new ArrayList<>();

        try {
            creditoAsignadoList = creditoAsignadoService.listAll();
            if (creditoAsignadoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, creditoAsignadoList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR CREDITOS ASIGNADOS", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('CREDITO ASIGNADO')")
    @GetMapping(value = "/creditoAsignado/{idCreditoAsignado}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarCreditoAsignadoPorIdCreditoAsignado(HttpServletRequest request, @PathVariable("idCreditoAsignado") String idCreditoAsignado) {

        ResponseEntity responseEntity;
        Response<CdCreditoAsignado> response;
        CdCreditoAsignado creditoAsignado = new CdCreditoAsignado();

        try {
            creditoAsignado = creditoAsignadoService.findByIdCreditoAsignado(idCreditoAsignado);
            if (creditoAsignado != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, creditoAsignado);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR CREDITO ASIGNADO POR ID", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('HISTORIAL DE PAGO')")
    @GetMapping(value = "/historialPago", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarHistorialPagos(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdHistorialPago> responseList;
        List<CdHistorialPago> historialPagoList = new ArrayList<>();

        try {
            historialPagoList = historialPagoService.listAll();
            if (historialPagoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, historialPagoList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR HISTORIAL DE PAGOS", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('HISTORIAL DE PAGO')")
    @GetMapping(value = "/historialPago/{fecha}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarHistorialPagoPorFecha(HttpServletRequest request, @PathVariable("fecha") String fecha) {

        ResponseEntity responseEntity;
        ResponseList<CdHistorialPago> responseList;
        List<CdHistorialPago> historialPagoList = new ArrayList<>();

        try {
            historialPagoList = historialPagoService.listByFecha(fecha);
            if (historialPagoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, historialPagoList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR HISTORIAL DE PAGO POR FECHA", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('CLIENTE')")
    @GetMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarClientes(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdCliente> responseList;
        List<CdCliente> clienteList = new ArrayList<>();

        try {
            clienteList = cdClienteService.listAll();
            if (clienteList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, clienteList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR CLIENTES", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('CLIENTE')")
    @GetMapping(value = "/cliente/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarClientePorIdCliente(HttpServletRequest request, @PathVariable("idCliente") Integer idCliente) {

        ResponseEntity responseEntity;
        Response<CdCliente> response;
        CdCliente cliente = new CdCliente();

        try {
            cliente = cdClienteService.findByIdCliente(idCliente);
            if (cliente != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, cliente);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR CLIENTE POR ID", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('FIADOR')")
    @GetMapping(value = "/fiador", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarFiadores(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdCliente> responseList;
        List<CdCliente> clienteList = new ArrayList<>();

        try {
            clienteList = cdClienteService.listAll();
            if (clienteList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, clienteList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR FIADORES", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('FIADOR')")
    @GetMapping(value = "/fiador/{idFiador}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarFiadorPorIdFiador(HttpServletRequest request, @PathVariable("idFiador") Integer idFiador) {

        ResponseEntity responseEntity;
        Response<CdCliente> response;
        CdCliente fiador = new CdCliente();

        try {
            fiador = cdClienteService.findByIdCliente(idFiador);
            if (fiador != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, fiador);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR FIADOR POR ID", request.getRequestURI(), response.getEstado() + " " + response.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), response.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('FIADOR ASIGNADO')")
    @GetMapping(value = "/fiadorAsignado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarFiadoresAsignados(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdFiadorAsignado> responseList;
        List<CdFiadorAsignado> fiadorAsignadoList = new ArrayList<>();

        try {
            fiadorAsignadoList = cdFiadorAsignadoService.listAll();
            if (fiadorAsignadoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, fiadorAsignadoList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR FIADORES ASIGNADOS", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('GARANTIA')")
    @GetMapping(value = "/garantia", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarGarantia(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdGarantia> responseList;
        List<CdGarantia> cdGarantiaList = new ArrayList<>();

        try {
            cdGarantiaList = cdGarantiaService.listAll();
            if (cdGarantiaList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, cdGarantiaList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR GARANTIA", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('GARANTIA ASIGNADO')")
    @GetMapping(value = "/garantiaAsignado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarGarantiasAsignados(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<CdGarantiaAsignado> responseList;
        List<CdGarantiaAsignado> cdGarantiaAsignadoList = new ArrayList<>();

        try {
            cdGarantiaAsignadoList = cdGarantiaAsignadoService.listAll();
            if (cdGarantiaAsignadoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, cdGarantiaAsignadoList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR GARANTIA ASIGNADO", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }
}
