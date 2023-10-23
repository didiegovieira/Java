package demo.exerciciolivraria.repository;

import demo.exerciciolivraria.entity.Livro;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Modifying
    @Query("UPDATE Livro SET titulo = ?1, autor = ?2 WHERE id = ?3")
    boolean atualizarTituloEautor(String novoTitulo, String novoAutor, Long id);

    void deleteById(Long id);

    List<Livro> findByDataPublicacaoAfter(LocalDate data);

    List<Livro> findByDisponibilidadeEstoqueTrue();

    List<Livro> findTop5ByDataPublicacaoBeforeOrderByDataPublicacaoDesc(LocalDate data);

    Livro findTopByOrderByPrecoDesc();
}
