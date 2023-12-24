package com.FilmesAPI.models.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity @Getter @Setter
public class Diretores {

    @Id
    private UUID diretorid;

    @NotBlank
    private String nome;

    public Diretores() {
        this.diretorid = UUID.randomUUID();
    }

    public Diretores(String nome) {
        this.nome = nome;
    }

}
