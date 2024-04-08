package br.com.curso.infrastructure.mapper;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.enuns.TransactionStatusEnum;
import br.com.curso.infrastructure.entity.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    private WalletMapper walletMapper;

    public TransactionMapper(WalletMapper walletMapper) {
        this.walletMapper = walletMapper;
    }

    public TransactionEntity toTransactionEntity(Transaction transaction) {
        return  new TransactionEntity(
               walletMapper.towalletEntity(transaction.getFromWallet()),
                walletMapper.towalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public TransactionEntity createTransaction(Transaction transaction) {
        return  new TransactionEntity(
                walletMapper.towalletEntity(transaction.getFromWallet()),
                walletMapper.towalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CREATED,
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public Transaction toTransaction(TransactionEntity transactionEntity) throws Exception {
        return new Transaction(
              transactionEntity.getId(),
              walletMapper.toWallet(transactionEntity.getFromWallet()),
              walletMapper.toWallet(transactionEntity.getToWallet()),
              transactionEntity.getValue(),
              transactionEntity.getStatus(), transactionEntity.getCreatedAt(), transactionEntity.getUpdatedAt()
        );
    }
}
