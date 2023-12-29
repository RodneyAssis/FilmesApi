package com.FilmesAPI.models.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity @Getter @Setter
public class Generos {

    @Id
    @Column(name = "generosid")
    private UUID idgenero;

    @NotBlank
    private String nome;


    public Generos(
    ) {
        this.idgenero = UUID.randomUUID();
    }

    public Generos(String nome) {
        this.nome = nome;
    }
}
