package com.FilmesAPI.models.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity @Getter @Setter
public class Atores {

    @Id
    private UUID atoresid;

    private String nome;

    public Atores() {
        this.atoresid = UUID.randomUUID();
    }

    public Atores(UUID atorid, String nome) {
        this.atoresid = atorid;
        this.nome = nome;
    }
}
