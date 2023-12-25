package com.FilmesAPI.models.repositorio;

import com.FilmesAPI.models.entidades.Atores;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface IAtorRepositorio extends CrudRepository<Atores, UUID> {

    @Query("SELECT a FROM Atores a WHERE a.atoresid = :atoresid")
    Iterable<Atores> findAtorForID(@Param("atoresid") UUID atoresid);



}
