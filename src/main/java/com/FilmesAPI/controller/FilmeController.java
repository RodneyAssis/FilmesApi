package com.FilmesAPI.controller;


import com.FilmesAPI.models.entidades.Filmes;
import com.FilmesAPI.models.repositorio.FilmeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/filmes")
public class FilmeController {
    @Autowired
    FilmeRepositorio filmeRepositorio;

//    Deverá ter os seguintes endPoints
//    [GET] Para obter todos os filmes
//        O retorno deverá ser o id do filme, título e classificação

    @GetMapping(path = "/all")
    public Iterable<Filmes> viewAllFilmes(){
        return filmeRepositorio.ConsultaAllFilmes();
    }

//    [GET] Obter filme pelo id
//        O retorno deverá ser o id,, titulo, descricao, ano de lançamento e classificação

    @GetMapping(path = "/{id}")
    public Optional<Filmes> viewAllForID(@PathVariable UUID id){
        return filmeRepositorio.findById(id);
    }

//    [POST] Para criar filmes
//        Post de todos os dados para criar o filme
//    [PUT] Para editar filmes
//        Put com todos os dados para editar o filme

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, path = "/salvar")
    public Filmes saveFilmes(Filmes filmes){
        filmeRepositorio.save(filmes);
        return filmes;
    }

}
