package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.DocumentoOrigen;
import com.idepro.appbackendnetbank.repository.DocumentoOrigenRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 9/11/2021.
 */
public interface DocumentoOrigenService {

    List<DocumentoOrigen> listAll();

}
