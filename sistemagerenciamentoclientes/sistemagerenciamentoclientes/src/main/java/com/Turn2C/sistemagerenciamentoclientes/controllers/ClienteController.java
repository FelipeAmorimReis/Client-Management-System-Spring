package com.Turn2C.sistemagerenciamentoclientes.controllers;

import com.Turn2C.sistemagerenciamentoclientes.models.Cliente;
import com.Turn2C.sistemagerenciamentoclientes.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.Turn2C.sistemagerenciamentoclientes.utils.Constants.*;

@RestController
@RequestMapping("/clientes")
@Tag(name = TAG_NAME, description = TAG_DESCRIPTION)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = OPERATION_LIST, description = OPERATION_LIST_DESCRIPTION)
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @Operation(summary = OPERATION_GET_CLIENT_BY_ID, description = OPERATION_GET_CLIENT_BY_ID_DESCRIPTION)
    @GetMapping("/{clienteId}")
    public Cliente getCliente(@PathVariable Long clienteId) {
        return clienteService.getCliente(clienteId);
    }

    @Operation(summary = OPERATION_CREATED_CLIENT, description = OPERATION_CREATED_CLIENT_DESCRIPTION)
    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }

    @Operation(summary = OPERATION_UPDATE_CLIENT, description = OPERATION_UPDATE_CLIENT_DESCRIPTION)
    @PutMapping("/{clienteId}")
    public Cliente atualizarCliente(@PathVariable Long clienteId, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(clienteId, cliente);
    }

    @Operation(summary = OPERATION_DELETED_CLIENT, description = OPERATION_DELETED_CLIENT_DESCRIPTION)
    @DeleteMapping("/{clienteId}")
    public void deletarCliente(@PathVariable Long clienteId) {
        clienteService.deletarCliente(clienteId);
    }
}
