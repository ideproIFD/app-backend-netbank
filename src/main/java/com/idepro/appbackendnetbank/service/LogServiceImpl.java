package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Log;
import com.idepro.appbackendnetbank.repository.LogRepository;
import com.idepro.appbackendnetbank.util.MethodUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.Date;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 14/7/2021.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;
    @Autowired
    private ServletContext context;

    @Override
    public void save(Log log, String request, String response) {

        String mensaje = "REQUEST: " + request + " - RESPONSE: " + response;
        String pathApp = context.getRealPath("");
//        String pathApp = "/usr/local/tomcat/";
        String nameFile = "logResponse" + MethodUtil.dateFileYYYYMMDD(new Date());
        MethodUtil.createAndModifyFile(pathApp, nameFile, mensaje);
        logRepository.saveLog(log.getUsuario(), log.getNombre(), log.getDireccionUrl(), log.getRespuesta(), pathApp + nameFile, log.getAddUser());
    }
}
