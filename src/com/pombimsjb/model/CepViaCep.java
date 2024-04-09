package com.pombimsjb.model;

public record CepViaCep(String cep, String logradouro, String complemento,
                        String bairro, String localidade, String uf, String ibge,
                        String ddd) {
}
