package br.com.curso.infrastructure.dto.request;

import br.com.curso.core.domain.enuns.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullName, UserTypeEnum type,String pin) {

}
