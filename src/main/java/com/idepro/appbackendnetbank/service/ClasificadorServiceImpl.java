package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Clasificador;
import com.idepro.appbackendnetbank.repository.ClasificadorRepository;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 12/5/2021.
 */
@Service
public class ClasificadorServiceImpl implements ClasificadorService {

    @Autowired
    private ClasificadorRepository clasificadorRepository;

    @Override
    public Clasificador save(Clasificador clasificador, String user) {
        clasificadorRepository.saveClasificadorIdpcon(clasificador.getPrefijo(), clasificador.getDescripcion(), clasificador.getAbreviacion(), user);
        return null;
    }

    @Override
    public Clasificador update(Clasificador clasificador, String user) {
        clasificadorRepository.updateClasificadorIdpcon(clasificador.getPrefijo(), clasificador.getCorrelativo(), clasificador.getDescripcion(), clasificador.getAbreviacion(), user);
        return clasificadorRepository.findByPrefijoByCorrelativoIdpcon(clasificador.getPrefijo(), clasificador.getCorrelativo());
    }

    @Override
    public List<Clasificador> listAll(String tabla) {
        List<Clasificador> clasificadorList = new ArrayList<>();
        switch (tabla) {
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_IDPCON:
                clasificadorList = clasificadorRepository.listAllIdpcon();
                break;
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_RECON:
                clasificadorList = clasificadorRepository.listAllRecon();
                break;
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_PRCON:
                clasificadorList = clasificadorRepository.listAllPrcon();
                break;
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_GBCON:
                clasificadorList = clasificadorRepository.listAllGbcon();
                break;
            default:
                break;
        }
        return clasificadorList;
    }

    @Override
    public List<Clasificador> listByPrefijo(Integer prefijo, String tabla) {
        List<Clasificador> clasificadorList = new ArrayList<>();
        switch (tabla) {
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_IDPCON:
                clasificadorList = clasificadorRepository.listByPrefijoIdpcon(prefijo);
                break;
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_RECON:
                clasificadorList = clasificadorRepository.listByPrefijoRecon(prefijo);
                break;
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_PRCON:
                clasificadorList = clasificadorRepository.listByPrefijoPrcon(prefijo);
                break;
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_GBCON:
                clasificadorList = clasificadorRepository.listByPrefijoGbcon(prefijo);
                break;
            default:
                break;
        }
        return clasificadorList;
    }

    @Override
    public Clasificador findByPrefijoByCorrelativo(Integer prefijo, Integer correlativo, String tabla) {
        Clasificador clasificador = null;
        switch (tabla) {
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_IDPCON:
                clasificador = clasificadorRepository.findByPrefijoByCorrelativoIdpcon(prefijo, correlativo);
                break;
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_RECON:
                clasificador = clasificadorRepository.findByPrefijoByCorrelativoRecon(prefijo, correlativo);
                break;
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_PRCON:
                clasificador = clasificadorRepository.findByPrefijoByCorrelativoPrcon(prefijo, correlativo);
                break;
            case ConstantsUtil.PARAM_MODEL_CLASIFICADOR_TABLA_GBCON:
                clasificador = clasificadorRepository.findByPrefijoByCorrelativoGbcon(prefijo, correlativo);
                break;
            default:
                break;
        }
        return clasificador;
    }
}
