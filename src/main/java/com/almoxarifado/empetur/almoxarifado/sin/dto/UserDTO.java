package com.almoxarifado.empetur.almoxarifado.sin.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String login;
    private String password;
    private String nomeCompleto;
    private String email;
    private LocalDateTime dataCadastro = LocalDateTime.now();
    private LocalDateTime ultimoAcesso;
    private String matricula;
    private String telefone;

}
