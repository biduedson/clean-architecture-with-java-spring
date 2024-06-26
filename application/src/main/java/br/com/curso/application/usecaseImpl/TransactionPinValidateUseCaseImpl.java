package br.com.curso.application.usecaseImpl;

import br.com.curso.application.gateway.TransactionPinValidateGateway;
import br.com.curso.application.gateway.UpdateTransactionPinUseCase;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.PinException;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enuns.ErrorCodeEnum;
import br.com.curso.usecase.TransactionPinValidateUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {
    private TransactionPinValidateGateway transactionPinValidateGateway;
    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway,UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public boolean validate(TransactionPin transactionPin) throws PinException {
        if(transactionPin.getBlocked())throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());

        if(!transactionPinValidateGateway.validate(transactionPin)){
            transactionPin.setAttempt();
         var transactionPinUpdated =   updateTransactionPinUseCase.update(transactionPin);
           throw  new PinException(ErrorCodeEnum.pin002GetMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.PIN0002.getCode());
        }

        if(transactionPin.getAttempt() < 3){
            transactionPin.restoreAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }
        return false;
    }
}
