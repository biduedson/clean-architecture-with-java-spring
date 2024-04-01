package br.com.curso.infrastructure.entity;

import br.com.curso.core.domain.enuns.UserTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
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

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "taxnumber", nullable = false)
    private String taxNumber;

    @Column(name = "Fullname",nullable = false)
    private String FullName;

    @Column(name = "type", nullable = false)
    private UserTypeEnum type;

    @Column(name = "createdat", nullable = false)
    private Timestamp createAt;

    @Column(name = "updateat")
    private Timestamp UpdatedAt;


}
