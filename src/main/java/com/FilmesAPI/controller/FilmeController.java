package com.FilmesAPI.controller;


import com.FilmesAPI.models.entidades.Filmes;
import com.FilmesAPI.models.repositorio.FilmePageRepositorio;
import com.FilmesAPI.models.repositorio.IFilmeRepositorio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/filmes")
public class FilmeController {
    @Autowired
    IFilmeRepositorio IFilmeRepositorio;
    @Autowired
    FilmePageRepositorio filmePageRepositorio;


    @GetMapping(path = "/page/{pages}")
    @Operation(description = "Paginando o conforme o numero filmes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição enviada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na indexação do numero de paginas.")
    })
    public Iterable<Filmes> numPagesFilmes(@PathVariable int pages){
        return filmePageRepositorio.findAll(PageRequest.of(pages, 5));
    }

    @GetMapping(path = "/viewAll")
    @Operation(description = "Exibe todos os filmes")
    public Iterable<Filmes> viewAllFilmes(){
        return IFilmeRepositorio.ConsultaAllFilmes();
    }

    @GetMapping(path = "/viewForID/{id}")
    @Operation(description = "Exibe filmes por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filme exibido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Item não encontrado")
    })
    public Object viewAllForID(@PathVariable UUID id){
        var viewForID = IFilmeRepositorio.findById(id);
        if (viewForID.isEmpty()) {
            return ResponseEntity.badRequest();
        }
        return viewForID;
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
    @Operation(description = "requisição para realizar alguma modificação nos dados do filme")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modificação realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Filme não encontrado ou ID inesistente")
    })
    public Filmes saveFilmes(@RequestBody Filmes filmes){
        IFilmeRepositorio.save(filmes);
        return filmes;
    }

    @DeleteMapping(path = "/deletaID/{id}")
    @Operation(description = "Deletar filme apartir do ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filme apagado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Filme não existe ou erro no ID")
    })
    public void deletarFilme(@PathVariable("id") UUID id){
        IFilmeRepositorio.deleteById(id);
    }

}
