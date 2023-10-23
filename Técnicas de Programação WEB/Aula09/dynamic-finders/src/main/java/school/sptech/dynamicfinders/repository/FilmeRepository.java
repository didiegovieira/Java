package school.sptech.dynamicfinders.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import school.sptech.dynamicfinders.entity.Filme;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

  // SELECT * FROM Filme WHERE LOWER(nome) LIKE LOWER('%titulo%');
  // Retorna uma lista de filmes cujo título contém (ignorando maiúsculas/minúsculas) a string fornecida.
  List<Filme> findByNomeContainsIgnoreCase(String titulo);

  // SELECT * FROM Filme WHERE LOWER(diretor) LIKE LOWER('%diretor%');
  // Retorna uma lista de filmes cujo diretor contém (ignorando maiúsculas/minúsculas) a string do diretor fornecida.
  List<Filme> findByDiretorContainsIgnoreCase(String diretor);

  // SELECT * FROM Filme WHERE data_lancamento <= :periodo;
  // Retorna uma lista de filmes com data de lançamento menor ou igual à data fornecida.
  List<Filme> findByDataLancamentoLessThanEqual(LocalDate periodo);

  // SELECT * FROM Filme WHERE indicacao_oscar = true;
  // Retorna uma lista de filmes que foram indicados ao Oscar.
  List<Filme> findByIndicacaoOscarTrue();

  // SELECT COUNT(*) FROM Filme WHERE indicacao_oscar = false;
  // Conta a quantidade de filmes que não foram indicados ao Oscar.
  Long countByIndicacaoOscarFalse();

  // SELECT * FROM Filme ORDER BY custo_producao DESC LIMIT 1;
  // Retorna o primeiro filme encontrado ordenado pelo custo de produção em ordem decrescente.
  Optional<Filme> findFirstByOrderByCustoProducaoDesc();

  // SELECT * FROM Filme ORDER BY custo_producao DESC LIMIT 3;
  // Retorna uma lista dos top 3 filmes ordenados pelo custo de produção em ordem decrescente.
  List<Filme> findTop3ByOrderByCustoProducaoDesc();

  List<Filme> findByDiretorAndIndicacaoOscar(String nome, boolean indicado);

  @Query("SELECT f FROM Filme f where f.diretor ILIKE %:nome% and f.indicacaoOscar = :indicado")
  //                                      OU
  //     @Query("SELECT f FROM Filme f where f.diretor = ?1 and f.indicacaoOscar = ?2")
  List<Filme> buscarPorDiretorIndicadosOscar(String nome, Boolean indicado);

  @Query("SELECT count(f) FROM Filme f where f.diretor ILIKE %:nome% and f.indicacaoOscar = :indicado")
  Integer contagemPorDiretorIndicadosOscar(String nome, Boolean indicado);

  @Modifying
  @Transactional
  @Query("UPDATE Filme f SET f.nome = :nome WHERE f.id = :id")
  Integer renomearFilme(String nome, Integer id);

  @Modifying
  @Transactional
  @Query("DELETE FROM Filme f WHERE f.id = :id")
  Integer deletarFilmePorId(Integer id);

//  @Query("SELECT f FROM Filme f where f.dataLancamento <= :data")
//  List<Filme> buscarPorPeriodo(LocalDate data);



}
