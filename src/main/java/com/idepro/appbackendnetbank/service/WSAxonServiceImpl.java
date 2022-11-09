package com.idepro.appbackendnetbank.service;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.util.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import static com.idepro.appbackendnetbank.util.ConstantsUtil.PARAM_IP_WS_AXON;
import static com.idepro.appbackendnetbank.util.ConstantsUtil.PARAM_WS_AXON_PROXIMA_CUOTA;
import static com.idepro.appbackendnetbank.util.ConstantsUtil.PARAM_WS_PAGO_CREDITO;
import static com.idepro.appbackendnetbank.util.ConstantsUtil.PARAM_WS_REVERSION_PAGO_CREDITO;

import static com.idepro.appbackendnetbank.util.ConstantsUtil.*;

@Service
public class WSAxonServiceImpl implements WSAxonService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public BigDecimal proximaCuotafindByCanalIdClinteIdApoderadoIdPrestamo(Integer canal, Integer idCliente, String plaza, Integer idApoderado, Integer idPrestamo) throws IOException {

        BigDecimal proximaCuota = new BigDecimal(0);
        String url = PARAM_IP_WS_AXON + PARAM_WS_AXON_PROXIMA_CUOTA + String.valueOf(canal) + '/' + String.valueOf(idCliente) + plaza  + '/' + String.valueOf(idApoderado) + plaza + '/' + String.valueOf(idPrestamo);

        String wsAxResponse = restTemplate.getForObject (url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        WsAxResponse wsAxRequest = mapper.readValue(wsAxResponse, WsAxResponse.class);
        List<WsAxproximaCuotaCredito> wsAxproximaCuotaCreditoList = wsAxRequest.getRows();
        for (WsAxproximaCuotaCredito wsAxproximaCuotaCredito: wsAxproximaCuotaCreditoList) {
            BigDecimal cuotaCredito = new BigDecimal(wsAxproximaCuotaCredito.getMontoProximaCuota());
            proximaCuota = proximaCuota.add(cuotaCredito);
        }
        return proximaCuota;
    }

    @Override
    public BcpConsultaPagoCovert proximaCuotafindByConversion(Integer canal, Integer idCliente, String plaza, Integer idApoderado, Integer idPrestamo) throws IOException {
        String url = PARAM_IP_WS_AXON + PARAM_WS_AXON_PROXIMA_CUOTA + String.valueOf(canal) + '/' + String.valueOf(idCliente) + plaza  + '/' + String.valueOf(idApoderado) + plaza + '/' + String.valueOf(idPrestamo);

        String wsAxResponse = restTemplate.getForObject (url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        WsAxResponse wsAxRequest = mapper.readValue(wsAxResponse, WsAxResponse.class);
        List<WsAxproximaCuotaCredito> wsAxproximaCuotaCreditoList = wsAxRequest.getRows();
        BcpConsultaPagoCovert consultaCovert = new BcpConsultaPagoCovert();
        for (WsAxproximaCuotaCredito wsAxproximaCuotaCredito: wsAxproximaCuotaCreditoList) {
            BigDecimal cuotaCredito = new BigDecimal(wsAxproximaCuotaCredito.getMontoProximaCuota());
            BigDecimal coversion = cuotaCredito.divide(BigDecimal.valueOf(100));

            consultaCovert.setFechaVencimiento(wsAxproximaCuotaCredito.getFechaDeIncumplimiento());
            consultaCovert.setImporteCuota(cuotaCredito);
            consultaCovert.setImporteCuotaDecimal(coversion);
        }
        return consultaCovert;
    }

    @Override
    public BigDecimal pagoCreditofindNumeroTransaccion(BcpRequest requestBody, BcpCliente cliente) throws IOException {
        BigDecimal numeroTransaccion = new BigDecimal(0);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Prueba caso
        // http://services-labo-netbank.idepro.org/WSClientAxon/PagoCredito/
        // objBcp.setCodigoCliente("123546");
        // objBcp.setCodigoApoderado("123546");
        // objBcp.setNumeroCredito("100100200"); // parm resquerido
        // objBcp.setFecha("23/09/2022"); // parm resquerido
        // objBcp.setMontoPago("50"); // parm resquerido REVISAR

        String uri = PARAM_IP_WS_AXON + PARAM_WS_PAGO_CREDITO;

        BcpPagoResquest objBcp = new BcpPagoResquest();
        objBcp.setCanal(PARAM_PAGO_CANAL);

        String conctCodCan = Integer.toString(cliente.getIdCliente()) + cliente.getPlaza();

        objBcp.setCodigoCliente(conctCodCan);
        objBcp.setCodigoApoderado(conctCodCan);
        objBcp.setNumeroCc(PARAM_NUMERO_CC);
        objBcp.setNumeroCredito(requestBody.getCodigoBusqueda()); // parm resquerido
        objBcp.setFecha(requestBody.getFechaPago()); // parm resquerido
        objBcp.setMoneda(PARAM_ESTADO_MONEDA);
        objBcp.setSigno1(PARAM_SIGLO_1);
        objBcp.setMontoPago(requestBody.getMontoTotal()); // parm resquerido REVISAR

        HttpEntity<BcpPagoResquest> httpEntity = new HttpEntity<>(objBcp, headers);
        RestTemplate restTemplate = new RestTemplate();
        String respPagoCreditoAxon = restTemplate.postForObject(uri, httpEntity, String.class);

        // System.out.println("myInteger es de tipo " +  ((Object)respPagoCreditoAxon).getClass().getSimpleName());

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        BcpPagoResponse objPagoCreditoAxon = mapper.readValue(respPagoCreditoAxon, BcpPagoResponse.class);

        List<WsAxPagoCredito> wsAxPagoCreditoList = objPagoCreditoAxon.getRows();
        if (wsAxPagoCreditoList != null){
            for (WsAxPagoCredito WsAxPagoCredito: wsAxPagoCreditoList) {
                BigDecimal numTransaccion = new BigDecimal(WsAxPagoCredito.getNumero_transaccion());
                numeroTransaccion = numeroTransaccion.add(numTransaccion);
            }
        }
        return numeroTransaccion;
    }

    @Override
    public String reversionPagoCreditofindNumeroTransaccion(BcpRequest requestBody) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String uri = PARAM_IP_WS_AXON + PARAM_WS_REVERSION_PAGO_CREDITO;

        BcpReversionRequest objBcpReversion = new BcpReversionRequest();
        objBcpReversion.setCanal(PARAM_REVERSION_CANAL);
        objBcpReversion.setIdPago(requestBody.getIdTransaccionEmpresa());
        objBcpReversion.setNumeroCredito(requestBody.getCodigoBusqueda());

        HttpEntity<BcpReversionRequest> httpEntity = new HttpEntity<>(objBcpReversion, headers);

        RestTemplate restTemplate = new RestTemplate();
        String respReversionPagoCreditoAxon = restTemplate.postForObject(uri, httpEntity, String.class);


        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        BcpReversionResponse objPagoCreditoAxon = mapper.readValue(respReversionPagoCreditoAxon, BcpReversionResponse.class);

        String messageReversion = objPagoCreditoAxon.getMessage();

        return messageReversion;
    }


    // Fuccion para consumir metodo POST en AXON
    public String consumoWSAxon(String pTipoConsumo, Object pRequestBody) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // probar
        String uri = PARAM_IP_WS_AXON + pTipoConsumo;

        BcpPagoResquest objBcp = new BcpPagoResquest();
        objBcp.setCanal(0);
        // objBcp.setCodigoCliente(pRequestBody.CodigoCliente);
        objBcp.setCodigoApoderado("154545");
        objBcp.setNumeroCc("0");
        objBcp.setNumeroCredito("100100200");
        objBcp.setFecha("23/09/2022");
        objBcp.setMoneda("Bs.");
        objBcp.setSigno1("-");
        objBcp.setMontoPago("50");


        HttpEntity<BcpPagoResquest> httpEntity = new HttpEntity<>(objBcp, headers);

        RestTemplate restTemplate = new RestTemplate();
        String respPagoCreditoAxon = restTemplate.postForObject(uri, httpEntity, String.class);

        // System.out.println("myInteger es de tipo " +  ((Object)respPagoCreditoAxon).getClass().getSimpleName());

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        BcpPagoResponse objPagoCreditoAxon = mapper.readValue(respPagoCreditoAxon, BcpPagoResponse.class);

        return null;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
