package com.FilmesAPI.controller;


import com.FilmesAPI.models.entidades.Diretores;
import com.FilmesAPI.models.repositorio.IDiretorRepositorio;
import jdk.dynalink.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/diretor")
public class DiretorController {
    @Autowired
    IDiretorRepositorio IDiretorRepositorio;


    // Consulta Geral
    @GetMapping(path = "/viewAll")
    public Iterable<Diretores> viewAllDiretor() {
        return IDiretorRepositorio.viewAllDiretor();
    }

    // Consulta por ID
    @GetMapping(path = "/viewAllForID/{id}")
    public Optional<Diretores> viewForID(@PathVariable UUID id){
        return IDiretorRepositorio.ViewForID(id);
    }

    // Adicionar Diretor

    @PostMapping(path = "/create")
    public Diretores adicionarDiretores(@RequestBody Diretores diretores){
        IDiretorRepositorio.save(diretores);
        return diretores;
    }

    // Alterar Diretor
    @PutMapping(path = "/update")
    public Diretores alterar(Diretores diretores){
        IDiretorRepositorio.save(diretores);
        return diretores;
    }

    //Remover
    @DeleteMapping(path = "/deleteID/{id}")
    public void deleteforID(@PathVariable UUID id){
        IDiretorRepositorio.deleteById(id);
    }

}
