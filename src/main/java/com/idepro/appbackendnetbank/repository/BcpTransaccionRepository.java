package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.BcpEstadoTransaccion;
import com.idepro.appbackendnetbank.model.CdCredito;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface BcpTransaccionRepository {
    BcpEstadoTransaccion findByIdEstadoTransaccion(String idPrestamo, String fechaPago);
    List<BcpEstadoTransaccion> findByIdHistorialTransaccion(String fechaInicio, String fechaFinal);

}
