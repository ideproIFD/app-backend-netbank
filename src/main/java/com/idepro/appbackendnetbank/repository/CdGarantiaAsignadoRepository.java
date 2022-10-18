package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.CdGarantiaAsignado;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 30/6/2022.
 */

@Repository
@Mapper
public interface CdGarantiaAsignadoRepository {
    List<CdGarantiaAsignado> listAll();
}
