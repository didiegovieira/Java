package exercicio.preparacaoprova.controller;

import exercicio.preparacaoprova.entity.Musica;
import exercicio.preparacaoprova.repository.MusicaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private final MusicaRepository musicaRepository;

    public MusicaController(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    //Enpoint adicional
    @GetMapping
    public ResponseEntity<List<Musica>> listagemGeral() {
        List<Musica> musicas = this.musicaRepository.findAll();

        if (musicas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(musicas);
    }

    //Enpoint adicional
    @GetMapping("/{id}")
    public ResponseEntity<Musica> buscarPorId(@PathVariable UUID id) {
        Optional<Musica> musica = this.musicaRepository.findById(id);
        return ResponseEntity.of(musica);
    }

    @GetMapping("/artista")
    public ResponseEntity<List<Musica>> buscarPorArtista(@RequestParam String nome) {
        List<Musica> musicasEncontradas = this.musicaRepository.findByArtista(nome);

        if (musicasEncontradas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(musicasEncontradas);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Musica>> buscarPorTitulo(@RequestParam String titulo) {
        List<Musica> musicasEncontradas = this.musicaRepository.findByNomeContainsIgnoreCase(titulo);

        if (musicasEncontradas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(musicasEncontradas);
    }

    @GetMapping("/genero/contagem")
    public ResponseEntity<Integer> contarPorGenero(@RequestParam String nome) {
        int i = this.musicaRepository.contagemGenero(nome);
        return ResponseEntity.ok(i);
    }

    @GetMapping("/nao-lancadas")
    public ResponseEntity<List<Musica>> buscarNaoLancadas() {
        List<Musica> musicasNaoLancadas = this.musicaRepository.findByDataLancamentoAfter(LocalDate.now());

        if (musicasNaoLancadas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(musicasNaoLancadas);
    }

    @GetMapping("/lancadas")
    public ResponseEntity<List<Musica>> buscarLancadas() {
        List<Musica> musicasLancadas = this.musicaRepository.findByDataLancamentoLessThanEqual(LocalDate.now());

        if (musicasLancadas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(musicasLancadas);
    }

    @GetMapping("/mais-acessos")
    public ResponseEntity<Musica> buscarMaisPopular() {
        Optional<Musica> maisPopular = this.musicaRepository.findFirstByOrderByAcessosDesc();
        return ResponseEntity.of(maisPopular);
    }

    @GetMapping("/top3-notas")
    public ResponseEntity<List<Musica>> buscarTop3MaioresNotas() {
        List<Musica> melhoresMusicas = this.musicaRepository.findTop3ByOrderByNotaDesc();

        if (melhoresMusicas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(melhoresMusicas);
    }

    @GetMapping("/genero/acessos/contagem")
    public ResponseEntity<Integer> buscarQuantidadeAcessosPorGenero(@RequestParam String nome) {
        Integer soma = this.musicaRepository.somaAcessos(nome).orElse(0); // Caso não encontre o genero, indicamos que retorna 0 caso is empty
        return ResponseEntity.ok(soma);
    }

    @GetMapping("/menor-nota")
    public ResponseEntity<Musica> buscarMenorNota() {
        Optional<Musica> musica = this.musicaRepository.menorNota();
        return ResponseEntity.of(musica);
    }
}
