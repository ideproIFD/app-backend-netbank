package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdPerfil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 15/8/2022.
 */
@Service
public class CdPerfilServiceImpl implements CdPerfilService {
    @Override
    public List<CdPerfil> listAll() {

        List<CdPerfil> cdPerfilList = new ArrayList<>();
        cdPerfilList.add(new CdPerfil("GS-JA","GERENTE DE SUCURSAL / JEFE DE AGENCIA"));
        cdPerfilList.add(new CdPerfil("ON-GC","OFICIAL DE NEGOCIO / GESTOR DE COBRANZA"));
        cdPerfilList.add(new CdPerfil("GNN","AREA COMERCIAL NACIONAL"));
        cdPerfilList.add(new CdPerfil("TIC","AREA TIC NACIONAL"));
        return cdPerfilList;
    }
}
