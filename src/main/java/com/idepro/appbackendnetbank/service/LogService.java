package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Log;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 14/7/2021.
 */
public interface LogService {

    @Transactional
    void save(Log log, String request, String response);
}
