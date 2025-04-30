package com.almoxarifado.empetur.almoxarifado.sin.enums;

import lombok.Getter;

@Getter
public enum TipoMovimentacao {

    ENTRADA("Entrada", "E", "Entrada de itens no Estoque"),
    SAIDA("SAÍDA", "S", "Retirada de itens do Estoque"),
    AJUSTE("Ajuste", "A", "Ajuste de estoque (inventário de correção)"),
    TRANSFERÊNCIA("Transferências", "T" , "Transferência entre almoxarifados"),
    DEVOLUÇÃO("Devolução", "D" ,"Devolução de itens ao fornecedor");

    private final String descricao;
    private final String sigla;
    private final String detalhe;

    TipoMovimentacao(String descricao, String sigla, String detalhe) {
        this.descricao = descricao;
        this.sigla = sigla;
        this.detalhe = detalhe;
    }
    //Método para buscar enum por sigla

    public static TipoMovimentacao porSigla(String sigla){
        for (TipoMovimentacao tipo : values()){
            if(tipo.getSigla().equalsIgnoreCase(sigla)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Sigla inválida: " +sigla);

    }

    public boolean isEntrada(){
        return this == ENTRADA || this == DEVOLUÇÃO;
    }

    public boolean isSaida(){
        return this == SAIDA || this == TRANSFERÊNCIA;
    }


    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDetalhe() {
        return detalhe;
    }
}
