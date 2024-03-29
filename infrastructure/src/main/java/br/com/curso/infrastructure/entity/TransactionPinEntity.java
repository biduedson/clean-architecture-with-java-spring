package br.com.curso.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TransactionsPin")
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

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime UpdatedAt;

    public TransactionPinEntity(String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        UpdatedAt = updatedAt;
    }
}
