package com.FilmesAPI.models.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity @Getter @Setter
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


}
