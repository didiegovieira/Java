package school.sptech.avaliacaocontinuada2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.avaliacaocontinuada2.entity.Producao;
import school.sptech.avaliacaocontinuada2.repository.ProducaoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producoes")
public class LivroController {

    /*
        Precisamos da sua ajuda aqui!
        Escreva os métodos abaixo:
    */

    private final ProducaoRepository producaoRepository;

    public LivroController(ProducaoRepository producaoRepository) {
        this.producaoRepository = producaoRepository;
    }

    //1. Buscar Produções por Nome do Diretor:
    @GetMapping("/diretor")
    public ResponseEntity<List<Producao>> listagemAutor(@RequestParam String nome) {
        List<Producao> producoesEncontrados = this.producaoRepository.findByDiretor(nome);

        if (producoesEncontrados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(producoesEncontrados);
    }

    //2. Buscar Produções por Parte do Título:
    @GetMapping("/titulo")
    public ResponseEntity<List<Producao>> listagemTitulo(@RequestParam String nome) {
        List<Producao> producoesEncontrados = this.producaoRepository.findByTituloContainsIgnoreCase(nome);

        if (producoesEncontrados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(producoesEncontrados);
    }

    //3. Contar Todas as Produções de um Gênero:
    @GetMapping("/genero")
    public ResponseEntity<Integer> listagemEditora(@RequestParam String nome) {
        int i = this.producaoRepository.countByGenero(nome);
        return ResponseEntity.ok(i);
    }

    //4. Buscar Produções com Data de Lançamento Após uma Data Específica:
    @GetMapping("/recentes")
    public ResponseEntity<List<Producao>> listagemRecentes(@RequestParam LocalDate data) {
        List<Producao> producoesNaoLancadas = this.producaoRepository.findByDataLancamentoAfter(data);

        if (producoesNaoLancadas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(producoesNaoLancadas);
    }

    //5. Buscar Produções com Data de Lançamento Antes ou na Data Específica:
    @GetMapping("/antigos")
    public ResponseEntity<List<Producao>> listagemAntigos(@RequestParam LocalDate data) {
        List<Producao> producoesLancadas = this.producaoRepository.findByDataLancamentoBefore(data);

        if (producoesLancadas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(producoesLancadas);
    }

    //6. Buscar a Produção Mais Votada (maior quantidade de avaliações):
    @GetMapping("/notas/mais-votado")
    public ResponseEntity<Producao> buscarMaisVotado() {
        Optional<Producao> maisPopular = this.producaoRepository.findFirstByOrderByQuantidadeAvaliacoesDesc();
        return ResponseEntity.of(maisPopular);
    }

    //7. Buscar Top 3 Produções com Maior Nota no IMDB:
    @GetMapping("/notas/top3")
    public ResponseEntity<List<Producao>> listagemMaisBaratos() {
        List<Producao> melhoresProducoes = this.producaoRepository.findTop3ByOrderByNotaImdbDesc();

        if (melhoresProducoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(melhoresProducoes);
    }
}
