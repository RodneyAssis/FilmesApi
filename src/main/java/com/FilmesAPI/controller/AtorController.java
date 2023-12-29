package com.FilmesAPI.controller;

import com.FilmesAPI.models.entidades.Atores;
import com.FilmesAPI.models.repositorio.IAtorRepositorio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/ator")
public class AtorController {

    @Autowired
    IAtorRepositorio iAtorRepositorio;


    @Operation(description = "Visualizar todos os atores registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Visualização com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados não encontrados.")
    })
    @GetMapping(path = "/viewAll")
    public Iterable<Atores> viewAllAtores(){
        return iAtorRepositorio.findAll();
    }


    @Operation(description = "Visualiza os Atores cadastrados apartir do ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem sucedida."),
            @ApiResponse(responseCode = "400", description = "Ator inesistente ou id incorreto")
    })
    @GetMapping(path = "/viewForID/{id}")
    public Iterable<Atores> visualizarPorID(@PathVariable UUID id) {
        return iAtorRepositorio.findAtorForID(id);
    }

    @Operation(description = "Cadastrar ator apartir apenas do nome não é necessario digitar UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuario não registrado devido ausencia de algum dado.")
    })
    @PostMapping(path = "/create")
    public void cadastrarAtor(Atores atores) {
        iAtorRepositorio.save(atores);
    }

    @Operation(description = "Alterar dado do ator apartir do ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "dado alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Ausencia de algum dado.")
    })
    @PutMapping(path = "/update")
    public void alterarAtor(Atores atores) {
        iAtorRepositorio.save(atores);
    }

    @Operation(description = "Deletar ator apartir do ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ator deletado sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao inserir o ID")
    })
    @DeleteMapping(path = "/deleteID/{id}")
    public void deletarPorID(@PathVariable UUID id){
        iAtorRepositorio.deleteById(id);
    }
}
