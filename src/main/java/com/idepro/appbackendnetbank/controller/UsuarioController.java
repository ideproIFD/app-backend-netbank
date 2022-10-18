package com.idepro.appbackendnetbank.controller;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.repository.ClasificadorRepository;
import com.idepro.appbackendnetbank.repository.ResetRepository;
import com.idepro.appbackendnetbank.service.UsuarioService;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 25/11/2020.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClasificadorRepository clasificadorRepository;
    @Autowired
    private ResetRepository resetRepository;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR USUARIOS WS')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listar() {

        ResponseEntity responseEntity;
        ResponseList<Usuario> responseList;
        List<Usuario> usuarioList = new ArrayList<>();

        try {
            usuarioList = usuarioService.listByEstado(null);
            if (usuarioList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, usuarioList);
                responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.OK);
            } else {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseList = new ResponseList<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('LISTAR USUARIOS WS POR ESTADO')")
    @GetMapping(value = "estado/{estado}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPorEstado(@PathVariable("estado") String estado) {

        ResponseEntity responseEntity;
        ResponseList<Usuario> responseList;
        List<Usuario> usuarioList = new ArrayList<>();

        try {
            usuarioList = usuarioService.listByEstado(estado);
            if (usuarioList.size() > 0) {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, usuarioList);
                responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.OK);
            } else {
                responseList = new ResponseList<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseList = new ResponseList<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<ResponseList>(responseList, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('BUSCA USUARIO WS POR ID USUARIO')")
    @GetMapping(value = "/{idUsuario}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> listarPorUsuario(@PathVariable("idUsuario") String idUsuario) {

        ResponseEntity responseEntity;
        Response<Usuario> response;
        Usuario usuario;
//        String idUsuario = request.getUsuario();

        try {
            usuario = usuarioService.findByUsuario(idUsuario);
            if (usuario != null) {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, usuario);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
            } else {
                response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('REGISTRAR USUARIO WS')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Entity> registrar(@RequestBody Request request) {

        String requestValidate = request.requestUsuario(request);
        ResponseEntity responseEntity;
        Response<Usuario> response;

        if (requestValidate == null) {
            Usuario usuario = new Usuario();
            usuario.setUsuario(request.getUsuario());
            usuario.setPassword(bcrypt.encode(request.getPassword()));
            usuario.setNombre(request.getNombre());
            usuario.setDescripcion(request.getDescripcion());
            usuario.setEmail(request.getEmail());
            usuario.setEstado(request.getEstado());
            usuario.setAddUser(request.getAddUser());
            Usuario usuarioReturnByUsuario;
            Usuario usuarioReturnByEmail;

            try {
                Clasificador clasificadorRol = clasificadorRepository.findByPrefijoByCorrelativoIdpcon(ConstantsUtil.PARAM_MODEL_CLASIFICADOR_ROL_WS, request.getIdRol());
                    if (clasificadorRol != null) {
                    usuario.setIdRol(clasificadorRol.getCorrelativo());
                    usuarioReturnByUsuario = usuarioService.save(usuario);
                    if (usuarioReturnByUsuario != null) {
                        response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, usuarioReturnByUsuario);
                        responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                    } else {
                        usuarioReturnByUsuario = usuarioService.findByUsuario(usuario.getUsuario());
                        usuarioReturnByEmail = usuarioService.findByEmail(usuario.getEmail());
                        if (usuarioReturnByUsuario != null || usuarioReturnByEmail != null) {
                            response = new Response<>(ConstantsUtil.PARAM_MENSAJE_YA_EXISTE_EL_REGISTRO + " (" + (usuarioReturnByUsuario != null ? " usuario " : "") + (usuarioReturnByEmail != null ? " email " : "") + ")", ConstantsUtil.PARAM_ESTADO_NOK, usuarioReturnByUsuario != null ? usuarioReturnByUsuario : usuarioReturnByEmail);
                            responseEntity = new ResponseEntity<Response>(response, HttpStatus.FOUND);
                        } else {
                            response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_USUARIO_NB, ConstantsUtil.PARAM_ESTADO_NOK, null);
                            responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                        }
                    }
                } else {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_ROL, ConstantsUtil.PARAM_ESTADO_NOK, null);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                }
            } catch (Exception e) {
                e.printStackTrace();
                response = new Response<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR_REQUEST(requestValidate), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('SOLICITAR RESET TOKEN')")
    @PostMapping(value = "/solicitarResetToken", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Entity> registrarResetToken(@RequestBody Request request) {

        String requestValidate = request.requestSolicitarResetToken(request);
        ResponseEntity responseEntity;
        Response<Reset> response;

        if (requestValidate == null) {
            try {
                String mensaje = usuarioService.saveResetVigente(request.getEmail(), request.getUsuario());
                if (mensaje == null) {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SAVE_RESET, ConstantsUtil.PARAM_ESTADO_OK, null);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                } else {
                    response = new Response<>(mensaje, ConstantsUtil.PARAM_ESTADO_NOK, null);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                }
            } catch (Exception e) {
                e.printStackTrace();
                response = new Response<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR_REQUEST(requestValidate), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('ACTUALIZAR USUARIO WS')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Entity> actualizar(@RequestBody Request request) {

        String requestValidate = request.requestUsuario(request);
        ResponseEntity responseEntity;
        Response<Usuario> response;

        if (requestValidate == null) {
            Usuario usuario = new Usuario();
            usuario.setUsuario(request.getUsuario());
            usuario.setPassword(bcrypt.encode(request.getPassword()));
            usuario.setNombre(request.getNombre());
            usuario.setDescripcion(request.getDescripcion());
            usuario.setEmail(request.getEmail());
            usuario.setEstado(request.getEstado());
            usuario.setAddUser(request.getAddUser());
            Usuario usuarioReturnByUsuario;

            try {
                Clasificador clasificadorRol = clasificadorRepository.findByPrefijoByCorrelativoIdpcon(ConstantsUtil.PARAM_MODEL_CLASIFICADOR_ROL_WS, request.getIdRol());
                if (clasificadorRol != null) {
                    usuario.setIdRol(clasificadorRol.getCorrelativo());
                    usuarioReturnByUsuario = usuarioService.update(usuario);
                    if (usuarioReturnByUsuario != null) {
                        response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, usuarioReturnByUsuario);
                        responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                    } else {
                        response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_USUARIO_NB, ConstantsUtil.PARAM_ESTADO_NOK, null);
                        responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                    }
                } else {
                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_ROL, ConstantsUtil.PARAM_ESTADO_NOK, null);
                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
                }
            } catch (Exception e) {
                e.printStackTrace();
                response = new Response<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
                responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            response = new Response<>(ConstantsUtil.MENSAJE_ERROR_REQUEST(requestValidate), ConstantsUtil.PARAM_ESTADO_NOK, null);
            responseEntity = new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

//    @PreAuthorize("@rolRecursoServiceImpl.validaRecurso('RESET PASSWORD')")
//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Entity> resetPassword(@RequestBody Request request) {
//
//        String requestValidate = request.requestResetPassword(request);
//        ResponseEntity responseEntity;
//        Response<Usuario> response;
//
//        if (requestValidate == null) {
//            try {
//                Usuario usuario = usuarioService.findByEmail(request.getEmail());
//                if (usuario != null) {
//                    if (resetRepository.findByTokenVigente(request.getToken()) != null) {
//                        response = new Response<>(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, /*usuarioReturnByUsuario*/ null);
//                        responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
//                    } else {
//                        response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_TOKEN, ConstantsUtil.PARAM_ESTADO_NOK, null);
//                        responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
//                    }
//                } else {
//                    response = new Response<>(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS + " - " + ConstantsUtil.PARAM_MODEL_USUARIO_NB, ConstantsUtil.PARAM_ESTADO_NOK, null);
//                    responseEntity = new ResponseEntity<Response>(response, HttpStatus.OK);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                response = new Response<>(ConstantsUtil.MENSAJE_ERROR(e.getLocalizedMessage()), ConstantsUtil.PARAM_ESTADO_NOK, null);
//                responseEntity = new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        } else {
//            response = new Response<>(ConstantsUtil.MENSAJE_ERROR_REQUEST(requestValidate), ConstantsUtil.PARAM_ESTADO_NOK, null);
//            responseEntity = new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
//        }
//        return responseEntity;
//    }
}
