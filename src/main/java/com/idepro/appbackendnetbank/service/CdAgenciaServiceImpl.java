package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdAgencia;
import com.idepro.appbackendnetbank.repository.CdAgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 28/3/2022.
 */
@Service
public class CdAgenciaServiceImpl implements CdAgenciaService {

    @Autowired
    private CdAgenciaRepository cdAgenciaRepository;

    @Override
    public CdAgencia findByIdAgencia(Integer idAgencia) {
        return cdAgenciaRepository.findByIdAgencia(idAgencia);
    }

    @Override
    public List<CdAgencia> listAll() {
        List<CdAgencia> agenciaList = cdAgenciaRepository.listAll();
        if (agenciaList == null) {
            agenciaList = new ArrayList<>();
        }
        return agenciaList;
    }

//    @Override
//    public List<CdAgencia> listAllAgencia() {
//        List<CdAgencia> agenciaList = cdAgenciaRepository.listAll();
//        if (agenciaList == null) {
//            agenciaList = new ArrayList<>();
//        }
//        return agenciaList;
//    }
}
