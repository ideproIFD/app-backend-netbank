package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.SudCliente;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/6/2022.
 */
@Repository
@Mapper
public interface SudClienteRepository {
    SudCliente findByCodigoCliente (String codigoCliente);
    List<SudCliente> listByNumeroDocumento (String numeroDocumento);
}
