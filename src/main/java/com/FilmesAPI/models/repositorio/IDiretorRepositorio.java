package com.FilmesAPI.models.repositorio;

import com.FilmesAPI.models.entidades.Diretores;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.Optional;
import java.util.UUID;

public interface IDiretorRepositorio extends CrudRepository<Diretores, UUID> {

    @Query("select d from Diretores d")
    Iterable<Diretores> viewAllDiretor();

    @Query("SELECT d FROM Diretores d WHERE d.diretorid = :diretorid")
    Optional<Diretores> ViewForID(@Param("diretorid") UUID diretorid);


}
