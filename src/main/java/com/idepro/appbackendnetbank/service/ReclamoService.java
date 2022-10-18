package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Reclamo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 16/11/2021.
 */
public interface ReclamoService {

    @Transactional
    Reclamo save(Reclamo reclamo);

    List<Reclamo> listReclamoByEmail(String email);

    List<Reclamo> listReclamoByNumeroDocumento(String numeroDocumento);
}
