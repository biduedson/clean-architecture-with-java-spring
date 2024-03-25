package br.com.curso.application.usecaseImpl;

import br.com.curso.application.gateway.CreateTransactionPinGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.usecase.CreateTransactionPinUseCase;

public class CreateTransactionPinUseCaseImpl implements CreateTransactionPinUseCase {
    private CreateTransactionPinGateway transactionPinGateway;

    public CreateTransactionPinUseCaseImpl(CreateTransactionPinGateway transactionPinGateway) {
        this.transactionPinGateway = transactionPinGateway;
    }

    @Override
    public void create(TransactionPin transactionPin) {
        transactionPinGateway.create(transactionPin);
    }
}
