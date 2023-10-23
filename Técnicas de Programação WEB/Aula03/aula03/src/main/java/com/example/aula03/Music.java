package com.example.aula03;

import java.time.LocalDate;

//Tabela musica
// Model
// Entity
// Domain nome da pasta onde esta a regra de negocio
public class Music {
    private String nome;
    private String artista;
    private LocalDate dataCriacao = LocalDate.now();

    // Sobrecarga, construtor vazio
    public Music(){

    }

    // Construtor
    public Music(String nome, String artista) {
        this.nome = nome;
        this.artista = artista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
