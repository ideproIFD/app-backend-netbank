package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BcpReversion {
    @JsonProperty("cod_error")
    private String codError;
    private String descripcion;
    @JsonProperty("codigo_busqueda")
    private String codigoBusqueda;
    @JsonProperty("id_reversion_empresa")
    private Integer idReversionEmpresa;
    @JsonProperty("id_reversion_entidad")
    private Integer idReversionEntidad;
}
