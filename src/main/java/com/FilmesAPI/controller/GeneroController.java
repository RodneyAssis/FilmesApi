package com.FilmesAPI.controller;


import com.FilmesAPI.models.entidades.Generos;
import com.FilmesAPI.models.repositorio.IGeneroRepositorio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping(path = "/api/genero")
public class GeneroController {

    @Autowired
    IGeneroRepositorio iGeneroRepositorio;

    @RequestMapping(method = RequestMethod.GET, path = "/view")
    @Operation(description = "Visualizar todos os registros de generos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Visualização efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na consulta")
    })
    public Optional<Generos> viewAll(){
        return iGeneroRepositorio.VisualizarTodos();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/viewForID/{id}")
    @Operation(description = "Visualizar os registros de generos por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na consulta")
    })
    public Iterable<Generos> viewForID(@PathVariable UUID id){
        return iGeneroRepositorio.viewForID(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    @Operation(description = "Cria novos registros de generos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Criação registrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na consulta")
    })
    public void addGenero(Generos generos){
        iGeneroRepositorio.save(generos);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/update")
    @Operation(description = "Atualizar dados ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na consulta")
    })
    public void uppGenero(Generos generos){
        iGeneroRepositorio.save(generos);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    @Operation(description = "Visualizar todos os registros de generos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Visualização efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na consulta")
    })
    public void  deletedGereno(@PathVariable UUID id){
        iGeneroRepositorio.deleteById(id);
    }
}
