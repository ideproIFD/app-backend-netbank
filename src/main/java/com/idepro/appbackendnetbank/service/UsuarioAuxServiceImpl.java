package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Clasificador;
import com.idepro.appbackendnetbank.model.Usuario;
import com.idepro.appbackendnetbank.repository.ClasificadorRepository;
import com.idepro.appbackendnetbank.repository.UsuarioRepository;
import com.idepro.appbackendnetbank.util.ConfigUtil;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 6/5/2021.
 */
@Service("userDetailsService")
public class UsuarioAuxServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ClasificadorRepository clasificadorRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Usuario usuario;
        if (userName.equals(ConfigUtil.PARAM_USER_SDM))
            usuario = new Usuario(userName, ConfigUtil.PARAM_PASSWORD_SDM, "", "", "", "", "", "", "", 1);
        else
            usuario = usuarioRepository.findByUsuario(userName);

        if (usuario == null) {
            System.out.println("Usuario no existe");
            throw new UsernameNotFoundException(String.format("Usuario no existe", userName));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        Clasificador clasificadorRol = clasificadorRepository.findByPrefijoByCorrelativoIdpcon(ConstantsUtil.PARAM_MODEL_CLASIFICADOR_ROL_WS, usuario.getIdRol());
        authorities.add(new SimpleGrantedAuthority(clasificadorRol == null ? ConstantsUtil.PARAM_MENSAJE_VACIO : clasificadorRol.getCorrelativo().toString()));
        UserDetails userDetails = new User(usuario.getUsuario(), usuario.getPassword().trim(), authorities);

        return userDetails;
    }
}
