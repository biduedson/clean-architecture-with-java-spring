package br.com.curso.infrastructure.entity;

import br.com.curso.core.domain.enuns.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Transactions")
public class TransactionEntity {
    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "FromWallet")
    private WalletEntity fromWallet;

    @ManyToOne
    @JoinColumn(name = "ToWallet")
    private WalletEntity toWallet;

    @Column(name = "TransactionValue", nullable = false)
    private BigDecimal value;

    @Column(name = "Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime UpdatedAt;


}
