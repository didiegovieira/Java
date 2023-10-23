package sptech.school.atividadevalidation.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.atividadevalidation.entity.Filme;
import sptech.school.atividadevalidation.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeRepository repository;

    @GetMapping
    public ResponseEntity<List<Filme>> listar() {
        List<Filme> filmes = this.repository.findAll();

        if (filmes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmes);
    }

    @PostMapping
    public ResponseEntity<Filme> adicionar(@RequestBody @Valid Filme filme) {
        Filme filmes = this.repository.save(filme);
        return ResponseEntity.status(201).body(filmes);
    }

    // POR ALGUM MOTIVO NAO FUNCIONOU DESTA FORMA:
//    @PutMapping("/{id}")
//    public ResponseEntity<Filme> alterar(@RequestBody Filme filme, @PathVariable int id) {
//        if (!this.repository.existsById(id)) {
//            return ResponseEntity.status(400).build();
//        }
//
//        this.repository.deleteById(id);
//
//        filme.setId(id);
//        Filme registroAtualizado = this.repository.save(filme);
//
//        return ResponseEntity.status(201).body(registroAtualizado);
//    }

    // ASSIM ESTA FEIO MAS FUNCIONA, A FUNÇÃO ACIMA NAO ESTAVA MUDANDO O ID
    @PutMapping("/{id}")
    public ResponseEntity<Filme> alterar(@RequestBody Filme filme, @PathVariable int id) {
        if (!this.repository.existsById(id)) {
            return ResponseEntity.status(400).build();
        }

        Filme registroExistente = this.repository.findById(id).orElse(null);

        if (registroExistente == null) {
            return ResponseEntity.status(500).build();
        }

        registroExistente.setTitulo(filme.getTitulo());
        registroExistente.setDiretor(filme.getDiretor());
        registroExistente.setDataLancamento(filme.getDataLancamento());
        registroExistente.setDuracao(filme.getDuracao());
        registroExistente.setNota(filme.getNota());
        registroExistente.setRanking(filme.getRanking());

        Filme registroAtualizado = this.repository.save(registroExistente);

        return ResponseEntity.status(201).body(registroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Filme> excluir(@PathVariable int id) {
        if (!this.repository.existsById(id)) {
            return ResponseEntity.status(404).build();
        }

        this.repository.deleteById(id);

        return ResponseEntity.status(204).build();
    }

}
