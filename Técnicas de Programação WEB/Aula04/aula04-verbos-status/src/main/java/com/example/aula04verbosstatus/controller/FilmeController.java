package com.example.aula04verbosstatus.controller;

import com.example.aula04verbosstatus.entity.Filme;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private List<Filme> listaFilmes = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Filme>> listar() {
        if (listaFilmes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(listaFilmes);
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme) {
        listaFilmes.add(filme);
        return ResponseEntity.status(201).body(filme);
    }

    // PUT - Devolve o objeto atualizado
    // DELETE - 200 ou 204 (Preferível)
    // GET POR Indice - Devolve por índice

    @PutMapping("/{indice}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme, @PathVariable int indice) {
        if (indice < 0 || indice > listaFilmes.size() || filme == null) {
            return ResponseEntity.status(204).body(filme);
        }

        listaFilmes.set(indice, filme);
        return ResponseEntity.status(201).body(filme);
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Filme> deletar(@PathVariable int indice) {
        if (indice < 0 || indice > listaFilmes.size()) {
            return ResponseEntity.status(204).body(listaFilmes.get(indice));
        }

        listaFilmes.remove(listaFilmes.get(indice));

        return ResponseEntity.status(202).body(listaFilmes.get(indice));
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Filme> getPorIndice (@PathVariable int indice) {
        if (indice < 0 || indice > listaFilmes.size()) {
            return ResponseEntity.status(204).body(listaFilmes.get(indice));
        }

        return ResponseEntity.status(200).body(listaFilmes.get(indice));
    }
}
