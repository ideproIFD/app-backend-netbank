package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by maruquipa on 23/11/2020.
 */
@Data
public class DatosOperacion {
    @JsonProperty("id_numero_operacion")
    private Integer idNumeroOperacion;
    @JsonProperty("monto_aprobado")
    private BigDecimal montoAprobado;
    @JsonProperty("id_moneda")
    private Integer  idMoneda;
    private String  moneda;
    @JsonProperty("id_destino_credito")
    private Integer  idDestinoCredito;
    @JsonProperty("destino_credito")
    private String  destinoCredito;
    @JsonProperty("monto_desembolsado")
    private BigDecimal  montoDesembolsado;
    @JsonProperty("id_estado_operacion")
    private Integer  idEstadoOperacion;
    @JsonProperty("estado_operacion")
    private String  estadoOperacion;
    @JsonProperty("id_rubro")
    private Integer  idRubro;
    private String  rubro;
    @JsonProperty("id_responsable_seguimiento")
    private Integer  idResponsableSeguimiento;
    @JsonProperty("responsable_seguimiento")
    private String  responsableSeguimiento;
    private Integer  plazo;
    @JsonProperty("frecuencia_pago")
    private Integer  frecuenciaPago;
    @JsonProperty("fecha_reprogramacion")
    private String  fechaReprogramacion;
    @JsonProperty("fecha_vencimiento")
    private String  fechaVencimiento;
    @JsonProperty("fecha_desembolso")
    private String  fechaDesembolso;
    @JsonProperty("dias_incumplidos")
    private Integer  diasIncumplidos;
    @JsonProperty("saldo_capital_afecha")
    private BigDecimal  saldoCapitalAfecha;
    @JsonProperty("garantias")
    private List<Garantia> garantiaList;
    @JsonProperty("ideprotege")
    private List<Ideprotege> ideprotegeList;
    @JsonProperty("cargos")
    private List<Cargo> cargosList;
}
