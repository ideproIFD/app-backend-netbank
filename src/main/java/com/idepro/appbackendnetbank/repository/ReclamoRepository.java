package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.Reclamo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 16/11/2021.
 */
@Repository
@Mapper
public interface ReclamoRepository {

    void saveReclamo(Integer idTipologia, Integer idSubTipologia, String localidadOficina, String glosa, BigDecimal importe, String moneda, String monedaExtranjera, String tipoDocumento, String numeroDocumento, String extencionDocumento, String nombre, String apellidos, String direccion1, String direccion2, String telefonoFijo, String telefonoCelular, String email);

    Reclamo findMaxNumeroReclamoByNumeroDocumento(String numeroDocumento);

    List<Reclamo> listReclamoByEmail(String email);

    List<Reclamo> listReclamoByNumeroDocumento(String numeroDocumento);
}
