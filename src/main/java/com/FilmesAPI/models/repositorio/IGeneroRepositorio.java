package com.FilmesAPI.models.repositorio;

import com.FilmesAPI.models.entidades.Generos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface IGeneroRepositorio extends CrudRepository<Generos, UUID>  {
    @Query("select g from Generos g where g.idgenero = :id")
    Iterable<Generos> viewForID(@Param("id") UUID id);

    @Query("select g from Generos g")
    Optional<Generos> VisualizarTodos();

}
