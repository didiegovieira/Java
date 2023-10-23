package aula05exercicios.aula05exercicios.controller;

import aula05exercicios.aula05exercicios.entity.Aluno;
import aula05exercicios.aula05exercicios.entity.Time;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    List<Aluno> alunos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno){
        if (aluno.getNome().length() < 3 || aluno.getNome().isBlank()) {
            return ResponseEntity.status(400).build();
        }

        if (!aluno.getEmail().contains("@") || !aluno.getEmail().contains(".school")) {
            return ResponseEntity.status(400).build();
        }

        if (aluno.getNotaContinuada1() < 0 || aluno.getNotaContinuada1() > 10) {
            return ResponseEntity.status(400).build();
        }

        if (aluno.getNotaContinuada2() < 0 || aluno.getNotaContinuada2() > 10) {
            return ResponseEntity.status(400).build();
        }

        if (aluno.getNotaContinuada3() < 0 || aluno.getNotaContinuada3() > 10) {
            return ResponseEntity.status(400).build();
        }

        if (aluno.getNotaIntegrada() < 0 || aluno.getNotaIntegrada() > 10) {
            return ResponseEntity.status(400).build();
        }

        alunos.add(aluno);

        return ResponseEntity.status(201).body(aluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getTodos() {
        return ResponseEntity.status(200).body(alunos);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Aluno> getUm(@PathVariable int indice) {
        if (!validacao(indice)) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(alunos.get(indice));
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Aluno> atualizar(@PathVariable int indice, @RequestBody Aluno aluno){
        if (!validacao(indice)) {
            return ResponseEntity.status(404).build();
        }

        alunos.set(indice, aluno);

        return ResponseEntity.status(200).body(alunos.get(indice));
    }

    public boolean validacao(int indice) {
        return indice >= 0 && indice < alunos.size();
    }
}
