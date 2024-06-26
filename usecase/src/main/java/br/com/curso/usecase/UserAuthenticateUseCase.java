package br.com.curso.usecase;

import br.com.curso.core.exception.AuthenticateException;

public interface UserAuthenticateUseCase {
    boolean authenticate(String username, String password) throws AuthenticateException;
}
