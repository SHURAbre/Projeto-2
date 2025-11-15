package br.mack.estagios.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ROLE_ADMIN,
        ROLE_EMPRESA,
        ROLE_ESTUDANTE
    }
}