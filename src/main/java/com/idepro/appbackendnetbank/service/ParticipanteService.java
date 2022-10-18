package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Cliente;
import com.idepro.appbackendnetbank.model.Participante;

import java.util.List;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 18/11/2020.
 */
public interface ParticipanteService {

    Participante listarParticipante(Integer idPrestamo);

    List<Cliente> ObtTitularByNumeroDocumento(String numeroDocumento);
}
