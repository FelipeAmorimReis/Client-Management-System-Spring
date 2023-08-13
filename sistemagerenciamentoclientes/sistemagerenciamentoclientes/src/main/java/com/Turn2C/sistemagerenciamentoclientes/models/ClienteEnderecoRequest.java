package com.Turn2C.sistemagerenciamentoclientes.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteEnderecoRequest {

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("logradouro")
    private String logradouro;

    @JsonProperty("cep")
    private int cep;

    @JsonProperty("numero")
    private int numero;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("uf")
    private String uf;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
