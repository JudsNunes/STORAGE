package com.almoxarifado.empetur.almoxarifado.sin.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Código é obrigatório")
    @Column(name = "codigo", nullable = false, unique = true,length = 20)
    private String codigo;

    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "quantidade", nullable = false)
    private Double quantidade;
    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;
    @Column(name = "unidade_medida", nullable = false, length = 20)
    private String unidMedida;
    @Column(name = "preco_unitario", nullable = false)
    private Double unidPreco;
    @NotBlank(message = "Fornecedor é necessário")
    @Column(name = "fornecedor", length = 100)
    private String fornecedor;
    @NotBlank(message = "Localização é necessário")
    @Column(name = "localizacao", length = 50)
    private String localizacao;
    @Column(name = "estoque_minimo")
    private Double estoqueMinimo;


}
