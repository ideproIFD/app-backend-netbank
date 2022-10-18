package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Reclamante;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 15/11/2021.
 */
public interface ReclamanteService {
    List<Reclamante> listAll();

    Reclamante saveReclamante(Reclamante reclamante);
}
