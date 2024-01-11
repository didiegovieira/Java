package sptech.school.atividade2sprint3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.atividade2sprint3.entity.Atleta;

import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta, Integer> {
    Atleta findByNome(String nome);
    Atleta findByPosicao(String posicao);
    List<Atleta> findAllByOrderByIdadeAsc();
}
