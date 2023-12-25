package com.FilmesAPI.controller;


import com.FilmesAPI.models.entidades.Diretores;
import com.FilmesAPI.models.repositorio.IDiretorRepositorio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/diretor")
public class DiretorController {
    @Autowired
    IDiretorRepositorio IDiretorRepositorio;


    @GetMapping(path = "/viewAll")
    @Operation(description = "Exibir todos os diretor")
    public Iterable<Diretores> viewAllDiretor() {
        return IDiretorRepositorio.viewAllDiretor();
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "Exibe diretor por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Diretor exibido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Item não encontrado")
    })
    public Optional<Diretores> viewForID(@PathVariable UUID id){
        return IDiretorRepositorio.ViewForID(id);
    }


    @PostMapping(path = "/create")
    @Operation(description = "adiciona Diretor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Diretor adicionado com sucesso")
    })
    public Diretores adicionarDiretores(@RequestBody Diretores diretores){
        IDiretorRepositorio.save(diretores);
        return diretores;
    }

    @PutMapping(path = "/update")
    @Operation(description = "requisição para realizar alguma modificação nos dados do diretor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modificação realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Filme não encontrado ou ID inesistente")
    })
    public Diretores alterar(Diretores diretores){
        IDiretorRepositorio.save(diretores);
        return diretores;
    }

    @DeleteMapping(path = "/deleteID/{id}")
    @Operation(description = "Remover Diretor apartir do ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Diretor apagado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Diretor não existe ou erro no ID")
    })

    public void deleteforID(@PathVariable UUID id){
        IDiretorRepositorio.deleteById(id);
    }

}
