package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.Clasificador;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 12/5/2021.
 */

@Repository
@Mapper
public interface ClasificadorRepository {

    void saveClasificadorIdpcon(Integer prefijo, String descripcion, String abreviacion, String addUser);

    void updateClasificadorIdpcon(Integer prefijo, Integer correlativo, String descripcion, String abreviacion, String addUser);

    List<Clasificador> listAllIdpcon();

    List<Clasificador> listAllRecon();

    List<Clasificador> listAllPrcon();

    List<Clasificador> listAllGbcon();

    List<Clasificador> listByPrefijoIdpcon(Integer prefijo);

    List<Clasificador> listByPrefijoRecon(Integer prefijo);

    List<Clasificador> listByPrefijoPrcon(Integer prefijo);

    List<Clasificador> listByPrefijoGbcon(Integer prefijo);

    Clasificador findByPrefijoByCorrelativoIdpcon(Integer prefijo, Integer correlativo);

    Clasificador findByPrefijoByCorrelativoRecon(Integer prefijo, Integer correlativo);

    Clasificador findByPrefijoByCorrelativoPrcon(Integer prefijo, Integer correlativo);

    Clasificador findByPrefijoByCorrelativoGbcon(Integer prefijo, Integer correlativo);
}
