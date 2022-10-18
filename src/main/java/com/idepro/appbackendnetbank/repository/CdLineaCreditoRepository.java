package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.CdLineaCredito;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 6/4/2022.
 */
@Repository
@Mapper
public interface CdLineaCreditoRepository {
    List<CdLineaCredito> listAll();
    CdLineaCredito findByIdLineaCredito(Integer idLineaCredito);
}
