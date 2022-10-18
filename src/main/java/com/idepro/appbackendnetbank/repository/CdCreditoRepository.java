package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.CdCredito;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 5/4/2022.
 */
@Repository
@Mapper
public interface CdCreditoRepository {
    List<CdCredito> listAll();
    CdCredito findByIdCredito(Integer idCredito);
}
