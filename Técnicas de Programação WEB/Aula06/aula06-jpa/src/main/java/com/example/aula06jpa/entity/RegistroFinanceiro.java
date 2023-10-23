package com.example.aula06jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class RegistroFinanceiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Double valor;
    private LocalDate data;

    public RegistroFinanceiro() {

    }

    public RegistroFinanceiro(String descricao, Double valor, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
