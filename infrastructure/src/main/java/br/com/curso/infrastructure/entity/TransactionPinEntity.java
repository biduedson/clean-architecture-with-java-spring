package br.com.curso.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactionspin")
public class TransactionPinEntity {
    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Pin", nullable = false)
    private  String pin;

    @Column(name = "Attempt", nullable = false)
    private  Integer attempt;

    @Column(name = "Blocked", nullable = false)
    private  Boolean blocked;

    @Column(name = "createdat", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updateat")
    private Timestamp UpdateAt;


    public TransactionPinEntity(String pin, Integer attempt, Boolean blocked, Timestamp createdAt, Timestamp updateAt) {
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        UpdateAt = updateAt;
    }
}
