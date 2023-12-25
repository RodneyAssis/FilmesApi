package com.FilmesAPI.models.repositorio;

import com.FilmesAPI.models.entidades.Filmes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.web.PageableArgumentResolver;

import java.util.UUID;

public interface FilmePageRepositorio extends PagingAndSortingRepository<Filmes, UUID> {

}
