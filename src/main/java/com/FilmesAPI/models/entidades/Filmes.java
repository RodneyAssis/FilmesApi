package com.FilmesAPI.models.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
public class Filmes {
    @Id
    private UUID filmeid;
    @NotBlank
    private String titulo;
    private String descricao;
    private int ano_lancamento;
    @Min(0) @Max(5)
    private int classificacao;


    public Filmes() {
        this.filmeid = UUID.randomUUID();
    }

    public Filmes(String titulo, String descricao, int ano_lancamento, int classificacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.ano_lancamento = ano_lancamento;
        this.classificacao = classificacao;
    }

    public UUID getFilmeid() {
        return filmeid;
    }

    public void setFilmeid(UUID filmeid) {
        this.filmeid = filmeid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAno_lancamento() {
        return ano_lancamento;
    }

    public void setAno_lancamento(int ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
}
