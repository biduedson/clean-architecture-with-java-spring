package br.com.curso.application.usecaseImpl;

import br.com.curso.application.gateway.EmailAvailableGateway;
import br.com.curso.core.exception.EmailException;
import br.com.curso.core.exception.enuns.ErrorCodeEnum;
import br.com.curso.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {
    public EmailAvailableGateway emailAvailableGateway;
    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public boolean emailAvailableEmail(String email) throws EmailException {
        return emailAvailableGateway.emailAvailable(email);
    }
}
