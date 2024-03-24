package br.com.curso.usecase;

import br.com.curso.core.exception.EmailException;

public interface EmailAvailableUseCase {
    boolean emailAvailableEmail(String email) throws EmailException;
}
