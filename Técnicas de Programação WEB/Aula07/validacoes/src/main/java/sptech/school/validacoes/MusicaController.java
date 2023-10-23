package sptech.school.validacoes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaRepository repository;

    @GetMapping
    public ResponseEntity<List<Musica>> listar() {
        List<Musica> musicas = this.repository.findAll();

        if (musicas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(musicas);
    }

    @PostMapping
    public ResponseEntity<Musica> adicionar(@RequestBody @Valid Musica musica) {
        Musica musicas = this.repository.save(musica);
        return ResponseEntity.status(201).body(musicas);
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Optional<Musica>> alterar(@RequestBody Musica musica, @PathVariable int indice) {
        if (musica.getNome().isBlank()) {
            return ResponseEntity.status(400).build();
        }

        Optional<Musica> musicas = this.repository.findById(indice);
        musicas = Optional.of(this.repository.save(musica));

        return ResponseEntity.status(201).body(musicas);
    }

    @DeleteMapping
    public ResponseEntity<Musica> excluir(@PathVariable int indice) {
        this.repository.deleteById(indice);

        return ResponseEntity.status(200).build();
    }
}
