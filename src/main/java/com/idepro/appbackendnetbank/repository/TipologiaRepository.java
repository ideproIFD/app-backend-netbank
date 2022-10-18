package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.Tipologia;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/11/2021.
 */
@Repository
@Mapper
public interface TipologiaRepository {

    List<Tipologia> listAll();

    List<Tipologia> listByIdTipologia(Integer idTipologia);

    Tipologia findByIdTipologiaByIdSubTipologia(Integer idTipologia, Integer idSubTipologia);
}
