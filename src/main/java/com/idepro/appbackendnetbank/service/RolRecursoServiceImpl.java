package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Clasificador;
import com.idepro.appbackendnetbank.model.RolRecurso;
import com.idepro.appbackendnetbank.repository.ClasificadorRepository;
import com.idepro.appbackendnetbank.repository.RolRecursoRepository;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 14/5/2021.
 */
@Service
public class RolRecursoServiceImpl implements RolRecursoService {

    @Autowired
    private RolRecursoRepository rolRecursoRepository;
    @Autowired
    private ClasificadorRepository clasificadorRepository;

    @Override
    public boolean validaRecurso(String recurso) {
        boolean sw = false;
        String idRol = "0";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
        //   System.out.println(authentication.getName());
            idRol = authentication.getAuthorities().iterator().next().getAuthority();
//            for (GrantedAuthority auth : authentication.getAuthorities()) {
//            }
        }

        if (ConstantsUtil.PARAM_MODEL_ROL_ADMIN.equals(idRol)) {
            sw = true;
        } else {
            List<RolRecurso> rolRecursoList = rolRecursoRepository.listByIdRol(Integer.parseInt(idRol));
            if (rolRecursoList.size() > 0) {
                Clasificador clasificadorRecurso;
                for (RolRecurso rolRecurso : rolRecursoList) {
                    clasificadorRecurso = clasificadorRepository.findByPrefijoByCorrelativoIdpcon(ConstantsUtil.PARAM_MODEL_CLASIFICADOR_RECURSO_WS, rolRecurso.getIdRecurso());
                    if (recurso.equals(clasificadorRecurso.getDescripcion().trim()))
                        sw = true;
                }
            }
        }
        return sw;
    }

    @Override
    public String obtUsuario() {
        String idRol = "0";
        String usuario = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            usuario = authentication.getName();
            idRol = authentication.getAuthorities().iterator().next().getAuthority();
//            for (GrantedAuthority auth : authentication.getAuthorities()) {
//            }
        }
        return usuario;
    }
}
