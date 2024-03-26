package br.com.curso.application.gateway;

public interface UserAuthenticateGateway {
    boolean authenticate(String username, String password);
}
