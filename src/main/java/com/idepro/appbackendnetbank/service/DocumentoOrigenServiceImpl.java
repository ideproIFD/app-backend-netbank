package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.DocumentoOrigen;
import com.idepro.appbackendnetbank.repository.DocumentoOrigenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 9/11/2021.
 */
@Service
public class DocumentoOrigenServiceImpl implements DocumentoOrigenService {

    @Autowired
    private DocumentoOrigenRepository documentoOrigenRepository;

    @Override
    public List<DocumentoOrigen> listAll() {
        List<DocumentoOrigen> documentoOrigenList = documentoOrigenRepository.listAll();
        if(documentoOrigenList == null){
            documentoOrigenList = new ArrayList<>();
        }
        return documentoOrigenList;
    }
}
