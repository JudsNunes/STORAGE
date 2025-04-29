package com.almoxarifado.empetur.almoxarifado.sin.entity;

import com.almoxarifado.empetur.almoxarifado.sin.enums.TipoMovimentacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name ="movimentacoes")
@AllArgsConstructor
public class Movements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoMovimentacao tipo;

    @Column(nullable = false,precision = 10,scale = 2)
    private Double quantidade;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(length = 50)
    private String documento;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, precision = 10, scale = 2)
    private double saldoAnterior;
    @Column(nullable = false, precision = 10, scale = 2)
    private double saldoAtual;

    public Movements(){
        this.data = LocalDateTime.now();
    }


    public Movements(Item item, TipoMovimentacao tipo, Double quantidade) {
        this();
        this.item = item;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }



}
