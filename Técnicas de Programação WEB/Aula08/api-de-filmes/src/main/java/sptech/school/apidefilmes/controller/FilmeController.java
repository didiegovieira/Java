package sptech.school.apidefilmes.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.apidefilmes.entity.Filme;
import sptech.school.apidefilmes.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeRepository repository;

    @PostMapping
    public ResponseEntity<Filme> adicionar(@RequestBody @Valid Filme filme) {
        Filme filmes = this.repository.save(filme);
        return ResponseEntity.status(201).body(filmes);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listar() {
        List<Filme> filmes = this.repository.findAll();

        if (filmes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Filme>> listarUm(@PathVariable int id) {
        Optional<Filme> filmes = this.repository.findById(id);

        if (filmes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> alterar(@RequestBody Filme filme, @PathVariable int id) {
        if (!this.repository.existsById(id)) {
            return ResponseEntity.status(400).build();
        }

        Filme registroExistente = this.repository.findById(id).orElse(null);

        if (registroExistente == null) {
            return ResponseEntity.status(500).build();
        }

        registroExistente.setNome(filme.getNome());
        registroExistente.setDiretor(filme.getDiretor());
        registroExistente.setDataLancamento(filme.getDataLancamento());
        registroExistente.setCustoProducao(filme.getCustoProducao());
        registroExistente.setIndicacaoOscar(filme.getIndicacaoOscar());

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

    @GetMapping("/titulo")
    public ResponseEntity<List<Filme>> buscaPorNome(@RequestParam String nome){
        List<Filme> listagem = this.repository.findByNomeContainsIgnoreCase(nome);

        if(listagem.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listagem);
    }

    @GetMapping("/diretor")
    public ResponseEntity<List<Filme>> buscaPorDiretor(@RequestParam String nome){
        List<Filme> listagem = this.repository.findByDiretorContains(nome);

        if(listagem.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listagem);
    }
}
