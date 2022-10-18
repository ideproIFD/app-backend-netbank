package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Reset;
import com.idepro.appbackendnetbank.repository.ResetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 21/5/2021.
 */
@Service
public class ResetServiceImpl implements ResetService {
     @Autowired
     private ResetRepository resetRepository;

}
