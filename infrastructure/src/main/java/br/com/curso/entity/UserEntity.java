package br.com.curso.entity;

import br.com.curso.core.domain.enuns.UserTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Users")
public class UserEntity {
    @Column(name = "id", nullable = false)
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


    public UserEntity(UUID id, String email, String password, String taxNumber, String fullName, UserTypeEnum type) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        FullName = fullName;
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }
}
