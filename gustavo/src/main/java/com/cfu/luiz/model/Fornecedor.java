package com.cfu.luiz.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idforncedor;

    private String nome;

    @Column(length = 14, unique = true)
    private String cnpj;

    private String email;
    private String telefone;
    private String celular;
    private String endereco;
    private String cidade;

    @Column(length = 2)
    private String estado;

    private Boolean status;
    private String categoriaFornecedor;

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
