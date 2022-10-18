package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Clasificador;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 12/5/2021.
 */
public interface ClasificadorService {

    Clasificador save(Clasificador clasificador, String user);

    Clasificador update(Clasificador clasificador, String user);

    List<Clasificador> listAll(String tabla);

    List<Clasificador> listByPrefijo(Integer prefijo, String tabla);

    Clasificador findByPrefijoByCorrelativo(Integer prefijo, Integer correlativo, String tabla);
}
