package com.Turn2C.sistemagerenciamentoclientes.services;

import com.Turn2C.sistemagerenciamentoclientes.models.ClienteEndereco;
import com.Turn2C.sistemagerenciamentoclientes.repository.ClienteEnderecoRepository;
import com.Turn2C.sistemagerenciamentoclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteEnderecoService {

    @Autowired
    private ClienteEnderecoRepository clienteEnderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteEndereco> listarEnderecos() {
        return clienteEnderecoRepository.findAll();
    }

    public ClienteEndereco getEndereco(Long idAddress) {
        return clienteEnderecoRepository.findById(idAddress).orElse(null);
    }

    public ClienteEndereco criarEndereco(ClienteEndereco endereco) {
        return clienteEnderecoRepository.save(endereco);
    }

    public ClienteEndereco atualizarEndereco(ClienteEndereco endereco) {
        if (clienteEnderecoRepository.existsById(endereco.getId())) {
            return clienteEnderecoRepository.save(endereco);
        }
        return null;
    }

    public void deletarEndereco(Long idAddress) {
        clienteEnderecoRepository.deleteById(idAddress);
    }
}
