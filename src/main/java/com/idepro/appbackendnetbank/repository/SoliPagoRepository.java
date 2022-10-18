package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.SoliPago;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 3/5/2022.
 */
@Repository
@Mapper
public interface SoliPagoRepository {

    List<SoliPago> listAll();
}
