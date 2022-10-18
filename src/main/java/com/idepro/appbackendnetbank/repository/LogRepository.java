package com.idepro.appbackendnetbank.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 14/7/2021.
 */
@Repository
@Mapper
public interface LogRepository {
    void saveLog(String usuario, String nombre, String direccionUrl, String respuesta, String ubicacionDetalle, String addUser);
}
