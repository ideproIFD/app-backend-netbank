package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Reclamante;
import com.idepro.appbackendnetbank.model.Reclamo;
import com.idepro.appbackendnetbank.repository.ReclamanteRepository;
import com.idepro.appbackendnetbank.repository.ReclamoAdicionalRepository;
import com.idepro.appbackendnetbank.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 16/11/2021.
 */
@Service
public class ReclamoServiceImpl implements ReclamoService {

    @Autowired
    private ReclamoRepository reclamoRepository;
    @Autowired
    private ReclamoAdicionalRepository reclamoAdicionalRepository;
    @Autowired
    private ReclamanteRepository reclamanteRepository;

    @Override
    @Transactional
    public Reclamo save(Reclamo reclamo) {

        Reclamo reclamoReturn;
        List<Reclamante> reclamanteList = reclamanteRepository.listByNumeroDocumentoByTipoDocumento(reclamo.getNumeroDocumento(), reclamo.getTipoDocumento());
        if (reclamanteList.size() == 0) {
            reclamanteRepository.saveReclamante(reclamo.getTipoDocumento(), reclamo.getNumeroDocumento(), reclamo.getExtencionDocumento(), reclamo.getNombre(), reclamo.getApellidos(), reclamo.getDireccion1(), reclamo.getDireccion2(), reclamo.getTelefonoFijo(), reclamo.getTelefonoCelular(), reclamo.getEmail(), reclamo.getUsuarioContacto());
        }

        reclamoRepository.saveReclamo(reclamo.getIdTipologia(), reclamo.getIdSubTipologia(), reclamo.getLocalidadOficina(), reclamo.getGlosa(), reclamo.getImporte(), reclamo.getMoneda(), reclamo.getMonedaExtranjera(), reclamo.getTipoDocumento(), reclamo.getNumeroDocumento(), reclamo.getExtencionDocumento(), reclamo.getNombre(), reclamo.getApellidos(), reclamo.getDireccion1(), reclamo.getDireccion2(), reclamo.getTelefonoFijo(), reclamo.getTelefonoCelular(), reclamo.getEmail());
        reclamoReturn = reclamoRepository.findMaxNumeroReclamoByNumeroDocumento(reclamo.getNumeroDocumento());
        reclamoAdicionalRepository.saveReclamoAdicional(reclamoReturn.getNumeroReclamo(), reclamo.getTipoReclamante(), reclamo.getNumeroTestimonio(), reclamo.getRepresentanteLegal(), reclamo.getFecha(), reclamo.getModoRespuesta(), reclamo.getTipoCredito(), reclamo.getNombreOficial());
        reclamoReturn = reclamoRepository.findMaxNumeroReclamoByNumeroDocumento(reclamo.getNumeroDocumento());
        return reclamoReturn;
    }

    @Override
    public List<Reclamo> listReclamoByEmail(String email) {
        List<Reclamo> reclamoList = reclamoRepository.listReclamoByEmail(email);
        if (reclamoList == null) {
            reclamoList = new ArrayList<>();
        }
        return reclamoList;
    }

    @Override
    public List<Reclamo> listReclamoByNumeroDocumento(String numeroDocumento) {
        List<Reclamo> reclamoList = reclamoRepository.listReclamoByNumeroDocumento(numeroDocumento);
        if (reclamoList == null) {
            reclamoList = new ArrayList<>();
        }
        return reclamoList;
    }
}
