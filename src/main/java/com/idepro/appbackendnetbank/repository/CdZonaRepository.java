package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.CdZona;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 29/3/2022.
 */
@Repository
@Mapper
public interface CdZonaRepository {

    List<CdZona> listAll();
    CdZona findByIdZona(Integer idZona);
}
