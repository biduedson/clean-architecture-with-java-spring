package br.com.curso.application.usecaseImpl;

import br.com.curso.application.gateway.TransferGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.NotFoundException;
import br.com.curso.core.exception.NotificationException;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enuns.ErrorCodeEnum;
import br.com.curso.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {
private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
private TransactionValidateUseCase transactionValidateUseCase;

private CreateTransactionUseCase createTransactionUseCase;
private TransferGateway transferGateway;

private UserNotificationUseCase userNotificationUseCase;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway,UserNotificationUseCase userNotificationUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
    }

    @Override
    public boolean transfer(String fromTaxNumber , String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException {
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        from.transfer(value);
        to.receiveTransfer(value);
        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        transactionValidateUseCase.validate(transaction);

        if(!transferGateway.transfer(transaction)){
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if(!userNotificationUseCase.notificate(transaction, to.getUser().getEmain())){
            throw  new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }

       return true;
    }
}
