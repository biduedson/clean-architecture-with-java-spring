package br.com.curso.application.gateway;

import br.com.curso.core.domain.TransactionPin;

public interface CreateTransactionPinGateway {
    void create(TransactionPin transactionPin);
}
