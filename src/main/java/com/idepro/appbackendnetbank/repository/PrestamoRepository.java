package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maruquipa on 19/11/2020.
 */
@Repository
@Mapper
public interface PrestamoRepository {

    List<Prestamo> listByNumeroPrestamo(String numeroDocumento);

    List<Prestamo> listByIdCliente(Integer idCliente);

    DatosSolicitud listSolicitudByIdPrestamo(Integer idPrestamo);

    List<Garantia> listGarantiaByIdPrestamo(Integer idPrestamo);

    DatosOperacion datoOperacionByIdPrestamo(Integer idPrestamo);

    List<Ideprotege> ideprotegeByIdPrestamo(Integer idPrestamo);

    List<Cargo> cargoByIdPrestamo(Integer idPrestamo);

}
