package sptech.school.atividade2sprint3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.atividade2sprint3.entity.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
    Equipe findByNome(String nome);
    Equipe findByNomeDoTecnico(String nomeDoTecnico);
}
