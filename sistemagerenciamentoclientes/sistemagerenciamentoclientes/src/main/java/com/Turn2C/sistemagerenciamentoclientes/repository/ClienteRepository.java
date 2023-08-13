package com.Turn2C.sistemagerenciamentoclientes.repository;

import com.Turn2C.sistemagerenciamentoclientes.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
