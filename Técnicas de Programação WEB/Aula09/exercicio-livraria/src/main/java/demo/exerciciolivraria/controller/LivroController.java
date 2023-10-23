package demo.exerciciolivraria.controller;

import demo.exerciciolivraria.entity.Livro;
import demo.exerciciolivraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    @Autowired
    public LivroController(LivroService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarTituloEautor(@PathVariable Long id, @RequestParam String novoTitulo, @RequestParam String novoAutor) {
        boolean atualizadoComSucesso = service.atualizarTituloEautor(novoTitulo, novoAutor, id);
        if (atualizadoComSucesso) {
            return ResponseEntity.ok("Livro atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirLivro(@PathVariable Long id) {
        boolean excluidoComSucesso = service.excluirLivro(id);
        if (excluidoComSucesso) {
            return ResponseEntity.ok("Livro excluído com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        }
    }

    @GetMapping("/nao-publicados")
    public ResponseEntity<List<Livro>> buscarLivrosNaoPublicados(@RequestParam LocalDate data) {
        List<Livro> livros = service.buscarLivrosNaoPublicados(data);
        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Livro>> listarLivrosDisponiveisNoEstoque() {
        List<Livro> livros = service.listarLivrosDisponiveisNoEstoque();
        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/ultimos-5")
    public ResponseEntity<List<Livro>> buscarUltimos5Livros(@RequestParam LocalDate data) {
        List<Livro> livros = service.buscarUltimos5Livros(data);
        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/mais-caro")
    public ResponseEntity<Livro> buscarLivroMaisCaro() {
        Livro livro = service.buscarLivroMaisCaro();
        if (livro == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livro);
    }

    // Outros métodos do controlador
}
