package sptech.school.apidefilmes.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.school.apidefilmes.entity.Filme;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    // Like %s%, ignorando case

    //SELECT colunas tabelas onde Campo
    List<Filme> findByNomeContainsIgnoreCase(String nome);
    List<Filme> findByDiretorContains(String nome);
    List<Filme> findByDataLancamentoLessThanEqual(LocalDate data);

    @Query(value = "SELECT * .....", nativeQuery = true)
    List<Filme> buscaTodos();

    List<Filme> findByIndicacaoOscarTrue();

    int countByIndicacaoOscarFalse();

    Optional<Filme> findFirstByOrderByCustoProducaoDesc();

    List<Filme> findTop3ByOrderByCustoProducaoDesc();
}
