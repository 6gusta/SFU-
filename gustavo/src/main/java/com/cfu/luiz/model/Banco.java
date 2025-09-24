package com.cfu.luiz.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity

public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idbanco;

    private String nomeBanco;
    private String agencia;
    private String contaCorrente;
    private String gerente;
    private String telefone;
    private String endereco;

    private BigDecimal saldo;
    private Boolean status;

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
