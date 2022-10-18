package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.LocalidadReclamo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 9/11/2021.
 */
@Repository
@Mapper
public interface LocalidadReclamoRepository {
    List<LocalidadReclamo> listAll();
}
