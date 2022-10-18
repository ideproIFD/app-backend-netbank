package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Cliente;
import com.idepro.appbackendnetbank.model.Codeudor;
import com.idepro.appbackendnetbank.model.Participante;
import com.idepro.appbackendnetbank.model.Prestamo;
import com.idepro.appbackendnetbank.repository.ParticipanteRepository;
import com.idepro.appbackendnetbank.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 18/11/2020.
 */
@Service
public class ParticipanteServiceImpl implements ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public Participante listarParticipante(Integer idPrestamo) {

        Participante participante = new Participante();
        Cliente titular = ObtTitularByIdPrestamo(idPrestamo);
        participante.setTitular(titular);
        List<Cliente> codeudorList = ObtCodeudor(idPrestamo,titular.getIdCliente());
        participante.setCodeudor(codeudorList);
        return participante;
    }

    public Cliente ObtTitularByIdPrestamo(Integer idPrestamo) {
        Cliente cliente = participanteRepository.listTitularByIdPrestamo(idPrestamo);
        List<Prestamo> prestamo = prestamoRepository.listByIdCliente(cliente.getIdCliente());
        cliente.setPrestamoList(prestamo);
        return cliente;
    }

    public List<Cliente> ObtTitularByNumeroDocumento(String numeroDocumento) {
        List<Cliente> clienteList = participanteRepository.listTitularByNumeroDocumento(numeroDocumento);
        return clienteList;
    }

    public Cliente ObtTitularByCodCliente(Integer idPrestamo) {
        Cliente cliente = participanteRepository.listTitularByIdPrestamo(idPrestamo);
        List<Prestamo> prestamo = prestamoRepository.listByIdCliente(cliente.getIdCliente());
        cliente.setPrestamoList(prestamo);
        return cliente;
    }

    public List<Cliente> ObtCodeudor(Integer idPrestamo, Integer idCliente) {
        List<Cliente> AuxClienteList = new ArrayList<>();
        List<Codeudor> codeudorList = participanteRepository.listCodeudorByIdPrestamo(idPrestamo,idCliente);
       for (Codeudor clientes: codeudorList) {
            Cliente titular = ObtCodeudores(clientes.getIdCliente());
            AuxClienteList.add(titular);
       }
        return AuxClienteList;
    }

    public Cliente ObtCodeudores(Integer idCliente) {

        Cliente cliente = participanteRepository.listCodeudorByIdCliente(idCliente);
        List<Prestamo> prestamo = prestamoRepository.listByIdCliente(cliente.getIdCliente());
        cliente.setPrestamoList(prestamo);
        return cliente;
    }
}
