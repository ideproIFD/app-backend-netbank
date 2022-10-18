package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.Reset;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 21/5/2021.
 */
@Repository
@Mapper
public interface ResetRepository {

    void saveReset(String token, String usuario);

    Reset findByTokenVigente(String token);

    List<Reset> listAll();
}
