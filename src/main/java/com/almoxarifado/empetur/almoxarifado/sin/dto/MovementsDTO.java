package com.almoxarifado.empetur.almoxarifado.sin.dto;


import com.almoxarifado.empetur.almoxarifado.sin.enums.TipoMovimentacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class MovementsDTO {

    private Long id;

    private Double quantidade;

    private LocalDateTime data;

    private String documento;

    private String observacao;

    private TipoMovimentacao tipo;

    private double saldoAtual;

    private double saldoAnterior;

    public MovementsDTO() {
    }

    public void validar(){
        if(tipo == null){
            throw new IllegalArgumentException("Tipo de movimentação é obrigatória");
        }
        if(quantidade == null){
            throw new IllegalArgumentException("Quantidade de movimentação é obrigatória");
        }
        if(documento == null || documento.trim().isEmpty()){
            throw new IllegalArgumentException("Documento é obrigatório");
        }
    }

}
