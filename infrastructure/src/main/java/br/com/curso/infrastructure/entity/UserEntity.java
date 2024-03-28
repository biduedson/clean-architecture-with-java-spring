package br.com.curso.infrastructure.entity;

import br.com.curso.core.domain.enuns.UserTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data// Esta anotaçãogera automaticamente os métodos toString(), equals(), hashCode(), getter e setter para todos os campos da classe.
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity {
    @Column(name = "Id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "TaxNumber", nullable = false)
    private String taxNumber;

    @Column(name = "FullName",nullable = false)
    private String FullName;

    @Column(name = "Type", nullable = false)
    private UserTypeEnum type;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime UpdatedAt;


}
