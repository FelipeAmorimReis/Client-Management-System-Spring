package com.Turn2C.sistemagerenciamentoclientes.controllers;

import com.Turn2C.sistemagerenciamentoclientes.models.Cliente;
import com.Turn2C.sistemagerenciamentoclientes.models.ClienteEndereco;
import com.Turn2C.sistemagerenciamentoclientes.models.ClienteEnderecoRequest;
import com.Turn2C.sistemagerenciamentoclientes.repository.ClienteRepository;
import com.Turn2C.sistemagerenciamentoclientes.services.ClienteEnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.Turn2C.sistemagerenciamentoclientes.utils.Constants.*;

@RestController
@RequestMapping("/enderecos")
@Tag(name = TAG_NAME_ADDRESS, description = TAG_DESCRIPTION_ADDRESS)
public class ClienteEnderecoController {

    @Autowired
    private ClienteEnderecoService clienteEnderecoService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Operation(summary = OPERATION_LIST_ADDRESS, description = OPERATION_LIST_ADDRESS_DESCRIPTION)
    @GetMapping
    public List<ClienteEndereco> listarEnderecos() {
        return clienteEnderecoService.listarEnderecos();
    }

    @Operation(summary = OPERATION_GET_ADDRESS_BY_ID, description = OPERATION_GET_ADDRESS_BY_ID_DESCRIPTION)
    @GetMapping("/{idAddress}")
    public ClienteEndereco getEndereco(@PathVariable Long idAddress) {
        return clienteEnderecoService.getEndereco(idAddress);
    }

    @Operation(summary = OPERATION_CREATED_ADDRESS, description = OPERATION_CREATED_ADDRESS_DESCRIPTION)
    @PostMapping("/{idClient}")
    public ClienteEndereco criarEndereco(@PathVariable Long idClient, @RequestBody ClienteEnderecoRequest endereco) {
        Cliente cliente = clienteRepository.findById(idClient).orElse(null);

        if (cliente != null) {
            ClienteEndereco enderecoEntity = new ClienteEndereco();
            enderecoEntity.setCliente(clienteRepository.findById(idClient).orElse(null));
            enderecoEntity.setBairro(endereco.getBairro());
            enderecoEntity.setLogradouro(endereco.getLogradouro());
            enderecoEntity.setCep(endereco.getCep());
            enderecoEntity.setNumero(endereco.getNumero());
            enderecoEntity.setCidade(endereco.getCidade());
            enderecoEntity.setUf(endereco.getUf());

            return clienteEnderecoService.criarEndereco(enderecoEntity);
        }
        return null;
    }

    @Operation(summary = OPERATION_UPDATE_ADDRESS, description = OPERATION_UPDATE_ADDRESS_DESCRIPTION)
    @PutMapping("/{idAddress}")
    public ClienteEndereco atualizarEndereco(@PathVariable Long idAddress, @RequestBody ClienteEnderecoRequest endereco) {
        ClienteEndereco enderecoEntity = clienteEnderecoService.getEndereco(idAddress);

        if (enderecoEntity != null) {
            enderecoEntity.setBairro(endereco.getBairro());
            enderecoEntity.setLogradouro(endereco.getLogradouro());
            enderecoEntity.setCep(endereco.getCep());
            enderecoEntity.setNumero(endereco.getNumero());
            enderecoEntity.setCidade(endereco.getCidade());
            enderecoEntity.setUf(endereco.getUf());

            return clienteEnderecoService.atualizarEndereco(enderecoEntity);
        }

        return null;
    }

    @Operation(summary = OPERATION_DELETED_ADDRESS, description = OPERATION_DELETED_ADDRESS_DESCRIPTION)
    @DeleteMapping("/{idAddress}")
    public void deletarEndereco(@PathVariable Long idAddress) {
        clienteEnderecoService.deletarEndereco(idAddress);
    }
}
