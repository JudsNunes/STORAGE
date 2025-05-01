package com.almoxarifado.empetur.almoxarifado.sin.dto;


import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDTO {

    private Long id;
    private String codigo;
    private String nome;
    private String descricao;
    private Double quantidade;
    private String categoria;
    private String unidMedida;
    private Double unidPreco;
    private String fornecedor;
    private String localizacao;
    private Double estoqueMinimo;
}
