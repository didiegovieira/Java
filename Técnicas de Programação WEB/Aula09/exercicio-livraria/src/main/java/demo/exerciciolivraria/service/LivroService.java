package demo.exerciciolivraria.service;

import demo.exerciciolivraria.entity.Livro;
import demo.exerciciolivraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public boolean atualizarTituloEautor(String novoTitulo, String novoAutor, Long id) {
        return repository.atualizarTituloEautor(novoTitulo, novoAutor, id);
    }

    public boolean excluirLivro(Long id) {

        repository.deleteById(id);
        return true;
    }

    public List<Livro> buscarLivrosNaoPublicados(LocalDate data) {
        return repository.findByDataPublicacaoAfter(data);
    }

    public List<Livro> listarLivrosDisponiveisNoEstoque() {
        return repository.findByDisponibilidadeEstoqueTrue();
    }

    public List<Livro> buscarUltimos5Livros(LocalDate data) {
        return repository.findTop5ByDataPublicacaoBeforeOrderByDataPublicacaoDesc(data);
    }

    public Livro buscarLivroMaisCaro() {
        return repository.findTopByOrderByPrecoDesc();
    }
}
