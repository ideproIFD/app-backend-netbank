package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.service.DocumentoOrigenService;
import com.idepro.appbackendnetbank.service.LogService;
import com.idepro.appbackendnetbank.service.ReporteReclamoDiferidoService;
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
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/12/2021.
 */
@RestController
@RequestMapping("/reportesReclamosDiferidos")
public class ReporteReclamoDiferidoController {

    @Autowired
    private RolRecursoService rolRecursoService;
    @Autowired
    private LogService logService;
    @Autowired
    private ReporteReclamoDiferidoService reporteReclamoDiferidoService;

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR REPORTE DE RECLAMOS DIFERIDOS')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listar(HttpServletRequest request) {

        ResponseEntity responseEntity;
        ResponseList<ReporteReclamoDiferido> responseList;
        List<ReporteReclamoDiferido> reporteReclamoDiferidoList = new ArrayList<>();

        try {
            reporteReclamoDiferidoList = reporteReclamoDiferidoService.listAll();
            if (reporteReclamoDiferidoList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, reporteReclamoDiferidoList);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR REPORTE DE RECLAMOS DIFERIDOS", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR REPORTE DE RECLAMOS DIFERIDOS ENTRE FECHAS')")
    @GetMapping(value = "/{fechaInicial}/{fechaFinal}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarEntreFechas(HttpServletRequest request, @PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {

        ResponseEntity responseEntity;
        ResponseList<ReporteReclamoDiferido> responseList;
        List<ReporteReclamoDiferido> reporteReclamoDiferidoList = new ArrayList<>();

        try {
            reporteReclamoDiferidoList = reporteReclamoDiferidoService.listEntreFechas(fechaInicial,fechaFinal);
            if (reporteReclamoDiferidoList.size() > 0) {
                List<ReporteReclamoDiferido> reporteReclamoDiferidoListResponse = new ArrayList<>();
                for(ReporteReclamoDiferido aux: reporteReclamoDiferidoList){
                    aux.setTipoOficina(aux.getTipoOficina().replaceAll("\r", ""));
                    aux.setLocalidadOficina(aux.getLocalidadOficina().replaceAll("\r", ""));
                    reporteReclamoDiferidoListResponse.add(aux);
                }
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, reporteReclamoDiferidoListResponse);
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
        Log log = new Log(rolRecursoService.obtUsuario(), "LISTAR REPORTE DE RECLAMOS DIFERIDOS ENTRE FECHAS", request.getRequestURI(), responseList.getEstado() + " " + responseList.getMensaje(), "", null);
        logService.save(log, request.getRequestURI(), responseList.toString());
        return responseEntity;
    }
}
