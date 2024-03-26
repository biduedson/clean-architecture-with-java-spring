package br.com.curso.application.gateway;

import br.com.curso.core.domain.Transaction;

public interface TransactionValidateGateway {
    boolean validate(Transaction transaction);
}
