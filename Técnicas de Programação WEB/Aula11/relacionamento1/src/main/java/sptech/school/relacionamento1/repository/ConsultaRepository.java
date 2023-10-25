package sptech.school.relacionamento1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sptech.school.relacionamento1.entity.Consulta;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    List<Consulta> findByMedicoNomeContainsIgnoreCase(String nome);

    @Query("SELECT c FROM Consulta c WHERE c.nomePaciente = :codigo") // named parameter
    List<Consulta> buscarPorCrm(String codigo);

    //@Query("SELECT SUM(p.preco) FROM Produto p")
}
