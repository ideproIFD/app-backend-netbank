package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.Cliente;
import com.idepro.appbackendnetbank.model.Codeudor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 18/11/2020.
 */
@Repository
@Mapper
public interface ParticipanteRepository {

    Cliente listTitularByIdPrestamo(Integer idPrestamo);
    List<Cliente> listTitularByNumeroDocumento(String numeroDocumento);
    Cliente listCodeudorByIdCliente(Integer idCliente);
    List<Codeudor> listCodeudorByIdPrestamo(Integer idPrestamo, Integer idCliente);
}
