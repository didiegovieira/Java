package sptech.school.atividadevalidation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.atividadevalidation.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
}
