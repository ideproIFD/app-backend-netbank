package com.idepro.appbackendnetbank.repository;


import com.idepro.appbackendnetbank.model.CdGarantia;
import com.idepro.appbackendnetbank.model.CdGestor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CdGarantiaRepository {
    List<CdGarantia> listAll();
}
