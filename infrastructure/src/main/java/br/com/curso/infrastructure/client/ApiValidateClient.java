package br.com.curso.infrastructure.client;

import br.com.curso.infrastructure.client.dto.response.ApiValidateResponse;

import org.springframework.web.bind.annotation.GetMapping;


public interface ApiValidateClient {
    ApiValidateResponse validate();
}
