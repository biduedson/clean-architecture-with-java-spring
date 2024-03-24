package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;

public interface TransactionValidateUseCase {
     boolean validate(Transaction transaction);
}
