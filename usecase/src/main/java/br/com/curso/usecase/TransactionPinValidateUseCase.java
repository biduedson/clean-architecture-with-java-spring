package br.com.curso.usecase;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.TransferException;

public interface TransactionPinValidateUseCase {
    boolean validate(TransactionPin transactionPin) throws TransferException;
}
