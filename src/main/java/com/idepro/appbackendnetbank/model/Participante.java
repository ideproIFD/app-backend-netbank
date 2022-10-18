package com.idepro.appbackendnetbank.model;

import lombok.Data;

import java.util.List;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 18/11/2020.
 */
@Data
public class Participante {

    private Cliente titular;
    List<Cliente> codeudor;
}
