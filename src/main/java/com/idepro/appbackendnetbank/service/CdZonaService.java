package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdZona;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 29/3/2022.
 */
public interface CdZonaService {
    List<CdZona> listAll();
    CdZona findByIdZona(Integer idZona);
}
