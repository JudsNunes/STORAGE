package com.almoxarifado.empetur.almoxarifado.sin.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "Login é obrigatório")
    @Size(min = 4, max = 20, message = "Login deve ter entre 4 e 20 caracteres")
    @Column(unique = true, nullable = false, length = 20)
    private String login;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Nome completo é obrigatório")
    @Size(max = 100, message = "Nome deve ter até 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nomeCompleto;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    @Column(unique = true, nullable = false, length = 100)
    private String email;


    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Column
    private LocalDateTime ultimoAcesso;

    @Column(length = 20)
    private String matricula;

    @Column(length = 15)
    private String telefone;
}
