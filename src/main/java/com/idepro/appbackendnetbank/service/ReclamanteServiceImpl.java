package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Reclamante;
import com.idepro.appbackendnetbank.repository.ReclamanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 15/11/2021.
 */
@Service
public class ReclamanteServiceImpl implements ReclamanteService {
    @Autowired
    private ReclamanteRepository reclamanteRepository;

    @Override
    public List<Reclamante> listAll() {
        List<Reclamante> reclamanteList = reclamanteRepository.listAll();
        if (reclamanteList == null) {
            reclamanteList = new ArrayList<>();
        }
        return reclamanteList;
    }

    @Override
    public Reclamante saveReclamante(Reclamante reclamante) {

        if (reclamante != null) {
            reclamanteRepository.saveReclamante(reclamante.getTipoDocumento(), reclamante.getNumeroDocumento(), reclamante.getExtencionDocumento(), reclamante.getNombre(), reclamante.getApellidos(), reclamante.getDireccion1(), reclamante.getDireccion2(), reclamante.getTelefonoFijo(), reclamante.getTelefonoCelular(), reclamante.getEmail(), reclamante.getUsuario());
        }
        return null;
    }
}
