package br.com.curso.usecase;

public interface UserAuthenticateUseCase {
    boolean authenticate(String username, String password);
}
