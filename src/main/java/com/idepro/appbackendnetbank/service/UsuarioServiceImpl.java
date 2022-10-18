package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Usuario;
import com.idepro.appbackendnetbank.repository.ResetRepository;
import com.idepro.appbackendnetbank.repository.UsuarioRepository;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 25/11/2020.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ResetRepository resetRepository;

    @Override
    public Usuario save(Usuario usuario) {
        Usuario usuarioByUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());
        Usuario usuarioByEmail = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioByUsuario == null && usuarioByEmail == null) {
            usuarioRepository.saveUsuario(usuario.getUsuario(), usuario.getPassword(), usuario.getNombre(), usuario.getDescripcion(), usuario.getEmail(), usuario.getEstado(), usuario.getAddUser(), usuario.getIdRol());
            usuarioByUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());
            if (usuarioByUsuario != null) {
                return usuarioByUsuario;
            } else
                return null;
        } else {
            return null;
        }
    }

    @Override
    public Usuario update(Usuario usuario) {
        Usuario usuarioByUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());
        if (usuarioByUsuario != null) {
            usuarioRepository.updateUsuario(usuario.getUsuario(), usuario.getPassword(), usuario.getNombre(), usuario.getDescripcion(), usuario.getEmail(), usuario.getEstado(), usuario.getAddUser(), usuario.getIdRol());
            ;
            return usuarioRepository.findByUsuario(usuario.getUsuario());
        } else {
            return null;
        }
    }

    @Override
    public Usuario findByUsuario(String usuario) {
        Usuario user = usuarioRepository.findByUsuario(usuario);
        if (user != null)
            return user;
        else
            return null;
    }

    @Override
    public Usuario findByEmail(String email) {
        Usuario user = usuarioRepository.findByEmail(email);
        if (user != null)
            return user;
        else
            return null;
    }

    @Override
    public List<Usuario> listByEstado(String estado) {

        List<Usuario> usuarioList;
        if (estado != null)
            usuarioList = usuarioRepository.listByEstado(estado);
        else
            usuarioList = usuarioRepository.listAll();

        return usuarioList;
    }

    @Override
    public String saveResetVigente(String email, String usuario) {
        String mensaje = null;
        Usuario user = usuarioRepository.findByEmail(email);
        if (user != null) {
            if (user.getUsuario().equals(usuario)) {
                resetRepository.saveReset("123456", usuario);
//                mensaje = ConstantsUtil.PARAM_MENSAJE_SAVE_RESET;
            } else {
                mensaje = ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " (USUARIO)";
            }
        } else {
            mensaje = ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " (EMAIL)";
        }
        return mensaje;
    }
}
