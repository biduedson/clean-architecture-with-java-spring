package br.com.curso.application.usecaseImpl;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.TransferException;
import br.com.curso.usecase.TransactionPinValidateUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {
    @Override
    public boolean validate(TransactionPin transactionPin) throws TransferException {
        return false;
    }
}
