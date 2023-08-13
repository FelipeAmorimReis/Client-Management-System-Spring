package com.Turn2C.sistemagerenciamentoclientes.services;

import com.Turn2C.sistemagerenciamentoclientes.models.Cliente;
import com.Turn2C.sistemagerenciamentoclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getCliente(Long clienteId) {
        return clienteRepository.findById(clienteId).orElse(null);
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Long clienteId, Cliente cliente) {
        if (clienteRepository.existsById(clienteId)) {
            cliente.setId(clienteId);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public void deletarCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
