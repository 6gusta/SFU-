package com.cfu.luiz.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ContatoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcontato;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private String tipoContato;
    private String valorContato;
    private String descricao;
    private Boolean principal;
    private Boolean status;
    private String horarioContato;

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

