package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.ParametroDiario;
import com.idepro.appbackendnetbank.repository.ParametroDiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 26/7/2022.
 */
@Service
public class ParametroDiarioServiceImpl implements ParametroDiarioService {
    @Autowired
    private ParametroDiarioRepository parametroDiarioRepository;

    @Override
    public ParametroDiario listParametroDiario() {
        return parametroDiarioRepository.listParametroDiario();
    }
}
