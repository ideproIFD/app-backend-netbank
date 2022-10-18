package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdAgencia;

import java.util.List;


/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 28/3/2022.
 */
public interface CdAgenciaService {

    CdAgencia findByIdAgencia(Integer idAgencia);

    List<CdAgencia> listAll();
}
