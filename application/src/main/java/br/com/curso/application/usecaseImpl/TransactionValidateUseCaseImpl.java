package br.com.curso.application.usecaseImpl;

import br.com.curso.application.gateway.TransactionValidateGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enuns.ErrorCodeEnum;
import br.com.curso.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {

    private TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public boolean validate(Transaction transaction) throws TransferException {
        if(!transactionValidateGateway.validate(transaction)){
            throw  new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }

        return true;
    }
}
