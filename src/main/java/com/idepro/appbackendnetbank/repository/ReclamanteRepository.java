package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.Reclamante;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 15/11/2021.
 */
@Repository
@Mapper
public interface ReclamanteRepository {
    List<Reclamante> listAll();
    List<Reclamante> listByNumeroDocumento(String numeroDocumento);
    List<Reclamante> listByNumeroDocumentoByTipoDocumento(String numeroDocumento, String tipoDocumento);
    void saveReclamante(String reagetdid, String reagendid, String reagepdid, String reagenomb, String reageapel, String reagedir1, String reagedir2, String reagetfij, String reagetcel, String reagemail, String reageuser);
}
