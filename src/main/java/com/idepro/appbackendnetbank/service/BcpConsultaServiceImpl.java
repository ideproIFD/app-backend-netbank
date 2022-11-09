package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.repository.BcpTransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.idepro.appbackendnetbank.util.ConstantsUtil.*;


@Service
public class BcpConsultaServiceImpl  implements  BcpConsultaService{

    @Autowired
    private BcpClienteService bcpClienteService;
    @Autowired
    private WSAxonService WSAxonService;
    @Autowired
    private ParametroDiarioService parametroDiarioService;
    @Autowired
    private BcpTransaccionRepository bcpTransaccionRepository;

    @Override
    public BcpConsulta findByIdPrestamoCodServicio(Integer idPrestamo, String codigoServicio) throws IOException {
        BcpCliente cliente = new BcpCliente();
        BcpConsulta bcpConsulta = new BcpConsulta();
        bcpConsulta.setCodigoBusqueda(String.valueOf(idPrestamo));
        bcpConsulta.setCodServicio(codigoServicio);
        bcpConsulta.setImporteAdeudado(BigDecimal.ZERO);
        bcpConsulta.setImporteAdeudado(BigDecimal.ZERO);
        bcpConsulta.setImporteAdeudadoDecimal(BigDecimal.ZERO);
        bcpConsulta.setImporteMinimo(BigDecimal.ZERO);
        bcpConsulta.setImporteMinimoDecimal(BigDecimal.ZERO);
        bcpConsulta.setImporteComision(BigDecimal.ZERO);
        bcpConsulta.setPagos(listaPagos(idPrestamo));
        cliente = bcpClienteService.findByIdPrestamo(idPrestamo);

        if (cliente != null) {
            BigDecimal proximaCuota = WSAxonService.proximaCuotafindByCanalIdClinteIdApoderadoIdPrestamo(PARAM_CONSULTA_CANAL, cliente.getIdCliente(), cliente.getPlaza(), cliente.getIdCliente(), idPrestamo);
            if (proximaCuota != BigDecimal.ZERO) {
               bcpConsulta.setCodError(COD_ERROR_1);
               bcpConsulta.setDescripcion(DESCRIPCION_1);
               bcpConsulta.setNombreCliente(cliente.getNombre());
               bcpConsulta.setImporteAdeudado(proximaCuota);
               bcpConsulta.setImporteAdeudadoDecimal(proximaCuota.divide(BigDecimal.valueOf(100)));
               bcpConsulta.setImporteMinimo(proximaCuota);
               bcpConsulta.setImporteMinimoDecimal(proximaCuota.divide(BigDecimal.valueOf(100)));
            } else {
                bcpConsulta.setCodError(COD_ERROR_2);
                bcpConsulta.setDescripcion(DESCRIPCION_3);
                bcpConsulta.setNombreCliente("");
            }
        } else {
            bcpConsulta.setCodError(COD_ERROR_2);
            bcpConsulta.setDescripcion(DESCRIPCION_3);
            bcpConsulta.setNombreCliente("");
        }
        return bcpConsulta;
    }

    @Override
    public BcpPago findByIdPagoCodServicio(BcpRequest requestInput) throws IOException {
        BcpCliente cliente = new BcpCliente();
        BcpPago bcpPago = new BcpPago();
        bcpPago.setCodigoBusqueda(requestInput.getCodigoBusqueda());
        bcpPago.setIdTransaccionEntidad(requestInput.getIdTransaccion());
        cliente = bcpClienteService.findByIdPrestamo(Integer.parseInt(requestInput.getCodigoBusqueda()));
        ParametroDiario parametroDiario = parametroDiarioService.listParametroDiario();
        // Validacion fecha netbank
        String fechaGetNetbank = parametroDiario.getFechaSistema();
        String[] parts = fechaGetNetbank.split("-");
        String anio = parts[0];
        String mes = parts[1];
        String dia = parts[2];
        String fechaNetbank = dia + "/" + mes + "/" + anio;

        if (cliente != null) {
            Integer idPrestamo = Integer.parseInt(requestInput.getCodigoBusqueda());
            BcpConsultaPagoCovert validarConsultaPago = WSAxonService.proximaCuotafindByConversion(PARAM_CONSULTA_CANAL, cliente.getIdCliente(), cliente.getPlaza(), cliente.getIdCliente(), idPrestamo);
            String montoTotalWS = String.valueOf(validarConsultaPago.getImporteCuota());
            if (fechaNetbank.equals(requestInput.getFechaPago())) {
                if (montoTotalWS.equals(requestInput.getMontoTotal())){
                    BigDecimal numTransaccion = WSAxonService.pagoCreditofindNumeroTransaccion(requestInput, cliente);
                    if (numTransaccion != BigDecimal.ZERO) {
                        bcpPago.setCodError(COD_ERROR_1);
                        bcpPago.setDescripcion(DESCRIPCION_1);
                        bcpPago.setIdTransaccionEmpresa(numTransaccion);
                    } else {
                        bcpPago.setCodError(COD_ERROR_2);
                        bcpPago.setDescripcion(DESCRIPCION_3);
                    }
                } else {
                    bcpPago.setCodError(COD_ERROR_4);
                    bcpPago.setDescripcion(PARAM_MENSAJE_SIN_REGISTROS + " - " + DESCRIPCION_6);
                }
            } else {
                bcpPago.setCodError(COD_ERROR_5);
                bcpPago.setDescripcion(PARAM_MENSAJE_SIN_REGISTROS + " - " + DESCRIPCION_2);
            }
        } else {
            bcpPago.setCodError(COD_ERROR_2);
            bcpPago.setDescripcion(DESCRIPCION_3);
        }
        return bcpPago;
    }

    @Override
    public BcpReversion findByIdReversionCodServicio(BcpRequest requestInput) throws IOException {
        BcpCliente cliente = new BcpCliente();

        BcpReversion bcpReversion = new BcpReversion();
        bcpReversion.setCodigoBusqueda(requestInput.getCodigoBusqueda());
        cliente = bcpClienteService.findByIdPrestamo(Integer.parseInt(requestInput.getCodigoBusqueda()));

        if (cliente != null) {
            String messageReversion = WSAxonService.reversionPagoCreditofindNumeroTransaccion(requestInput);
            if (messageReversion.equals(PARAM_MESSAGE_REVERSION)) {
                bcpReversion.setCodError(COD_ERROR_1);
                bcpReversion.setDescripcion(DESCRIPCION_1);
                bcpReversion.setIdReversionEntidad(requestInput.getIdReversion());
                bcpReversion.setIdReversionEmpresa(requestInput.getIdTransaccionEmpresa());
            } else {
                bcpReversion.setCodError(COD_ERROR_3);
                bcpReversion.setDescripcion(DESCRIPCION_5);
            }
        } else {
            bcpReversion.setCodError(COD_ERROR_2);
            bcpReversion.setDescripcion(DESCRIPCION_3);
        }
        return bcpReversion;
    }

    @Override
    public BcpEstadoTransaccion findByIdEstadoTransaccion(String idPrestamo, String fechaPago)  {
        return bcpTransaccionRepository.findByIdEstadoTransaccion(idPrestamo, fechaPago);
    }

    @Override
    public List<BcpEstadoTransaccion> findByIdHistorialTransaccion(String fechaInicio, String fechaFinal,String idTransaccionEnpresa) throws IOException {
        List<BcpEstadoTransaccion> AuxbcpEstadoTransaccionList = new ArrayList<>();
        List<BcpEstadoTransaccion> bcpHistorialTransaccionList = bcpTransaccionRepository.findByIdHistorialTransaccion(fechaInicio,fechaFinal);



              for (BcpEstadoTransaccion transaccion: bcpHistorialTransaccionList) {
                  transaccion.setCodError(COD_ERROR_1);
                  transaccion.setDescripcion(DESCRIPCION_1);
                  transaccion.setIdTransaccionEmpresa(idTransaccionEnpresa);
                  AuxbcpEstadoTransaccionList.add(transaccion);
              }


        return AuxbcpEstadoTransaccionList;
    }

    public List<BcpConsultaPago> listaPagos(Integer idPrestamo) throws IOException {
        BcpCliente cliente = new BcpCliente();
        List<BcpConsultaPago> bcpConsultaPagoList = new ArrayList<>();
        Date fecha = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        // SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); // cambio de fecha
        String fechaActual= format.format(fecha);

        cliente = bcpClienteService.findByIdPrestamo(idPrestamo);
        if (cliente != null) {
            BcpConsultaPagoCovert proximaCuota = WSAxonService.proximaCuotafindByConversion(PARAM_CONSULTA_CANAL, cliente.getIdCliente(), cliente.getPlaza(), cliente.getIdCliente(), idPrestamo);
            BcpConsultaPago bcpConsultaPago = new BcpConsultaPago();
            bcpConsultaPago.setNumeroCuota(PARAM_CONSULTA_CANAL); // * REVISAR PENDIENTE
            bcpConsultaPago.setDetalleCuota(PARAM_DETALLE_CUOTA); // * REVISAR PENDIENTE
            bcpConsultaPago.setFechaVencimiento(proximaCuota.getFechaVencimiento());  // * REVISAR PENDIENTE (FECHA INCUMPLIMIENTO WS AXON)
            bcpConsultaPago.setImporteCuota(proximaCuota.getImporteCuota());
            bcpConsultaPago.setImporteCuotaDecimal(proximaCuota.getImporteCuotaDecimal());
            bcpConsultaPago.setImporteMinimoCuota(proximaCuota.getImporteCuota());
            bcpConsultaPago.setImporteMinimoCuotaDecimal(proximaCuota.getImporteCuotaDecimal());
            bcpConsultaPago.setMoraCuota(BigDecimal.ZERO); // * REVISAR PENDIENTE
            bcpConsultaPago.setImporteComision(BigDecimal.ZERO); // * REVISAR PENDIENTE
            bcpConsultaPagoList.add(bcpConsultaPago);

            return bcpConsultaPagoList;
        } else {
            return null;
        }
    }
}
