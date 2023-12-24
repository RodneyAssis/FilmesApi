package com.FilmesAPI.models.repositorio;

import com.FilmesAPI.models.entidades.Filmes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IFilmeRepositorio extends CrudRepository<Filmes, UUID> {
    @Query("SELECT f FROM Filmes f")
    Iterable<Filmes> ConsultaAllFilmes();
}
