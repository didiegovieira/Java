package aula05exercicios.aula05exercicios.controller;

import aula05exercicios.aula05exercicios.entity.Time;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {
    List<Time> times = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Time> cadastrar(@RequestBody Time time){
        if (time.getNome().isBlank() || time.getNome().length() < 3) {
            return ResponseEntity.status(400).build();
        }

        if (time.getTreinador().isBlank() || time.getTreinador().length() < 2) {
            return ResponseEntity.status(400).build();
        }

        times.add(time);

        return ResponseEntity.status(201).body(time);
    }

    @GetMapping
    public ResponseEntity<List<Time>> getLista(){
        return ResponseEntity.status(200).body(times);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Time> getTimeEspecifico(@PathVariable int indice) {
        if (!validacao(indice)){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(times.get(indice));
    }

    @PostMapping("/{indice}/registrar-vitoria")
    public ResponseEntity<Time> adicionarVitoria(@PathVariable int indice) {
        if (!validacao(indice)){
            return ResponseEntity.status(404).build();
        }

        times.get(indice).setVitorias(times.get(indice).getVitorias() + 1);

        return ResponseEntity.status(200).body(times.get(indice));
    }

    @PostMapping("/{indice}/registrar-derrota")
    public ResponseEntity<Time> adicionarDerrota(@PathVariable int indice) {
        if (!validacao(indice)){
            return ResponseEntity.status(404).build();
        }

        times.get(indice).setDerrotas(times.get(indice).getDerrotas() + 1);

        return ResponseEntity.status(200).body(times.get(indice));
    }

    @PostMapping("/{indice}/registrar-empate")
    public ResponseEntity<Time> adicionarEmpate(@PathVariable int indice) {
        if (!validacao(indice)){
            return ResponseEntity.status(404).build();
        }

        times.get(indice).setEmpates(times.get(indice).getEmpates() + 1);

        return ResponseEntity.status(200).body(times.get(indice));
    }

    public boolean validacao(int indice) {
        return indice >= 0 && indice < times.size();
    }
}
