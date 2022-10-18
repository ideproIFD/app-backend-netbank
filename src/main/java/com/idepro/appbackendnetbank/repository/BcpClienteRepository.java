package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.BcpCliente;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BcpClienteRepository {
    BcpCliente findByIdPrestamo(Integer idPrestamo);
}
