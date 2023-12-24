package com.FilmesAPI.controller;


import com.FilmesAPI.models.entidades.Filmes;
import com.FilmesAPI.models.repositorio.IFilmeRepositorio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/filmes")
public class FilmeController {
    @Autowired
    IFilmeRepositorio IFilmeRepositorio;


    @GetMapping(path = "/viewAll")
    @Operation(description = "Exibe todos os filmes")
    public Iterable<Filmes> viewAllFilmes(){
        return IFilmeRepositorio.ConsultaAllFilmes();
    }



    @GetMapping(path = "/{id}")
    @Operation(description = "Exibe filmes por ID")
    @ApiResponses(value = {

    })
    public Optional<Filmes> viewAllForID(@PathVariable UUID id){
        return IFilmeRepositorio.findById(id);
    }


    @PostMapping(path = "/create")
    @Operation(description = "adiciona filmes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filme adicionado com sucesso")
    })
    public UUID addFilme(@RequestBody Filmes filmes){
        IFilmeRepositorio.save(filmes);
        return filmes.getFilmeid();
    }

    @PutMapping(path = "/update")
    @Operation(description = "requisição para realizar alguma modificação no filme")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modificação realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Filme não encontrado ou ID inesistente")
    })
    public Filmes saveFilmes(@RequestBody Filmes filmes){
        IFilmeRepositorio.save(filmes);
        return filmes;
    }



}
