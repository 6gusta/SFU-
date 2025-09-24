package com.cfu.luiz.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;

    private String nomeCompleto;

    @Column(length = 11, unique = true)
    private String cpf;

    @Column(length = 14, unique = true)
    private String cnpj;

    private LocalDate dataNascimento;
    private String genero;
    private String email;
    private String telefone;
    private String celular;
    private String estadoCivil;
    private String profissao;
    private String empresa;
    private BigDecimal rendaMensal;
    private BigDecimal limiteCredito;
    private Integer pontuacaoCredito;
    private Boolean statusCliente;
    private String tipoCliente;

    @Lob
    private String observacoes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
