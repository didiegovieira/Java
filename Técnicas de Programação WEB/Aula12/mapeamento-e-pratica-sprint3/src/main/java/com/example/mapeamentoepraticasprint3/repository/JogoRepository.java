package com.example.mapeamentoepraticasprint3.repository;

import com.example.mapeamentoepraticasprint3.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {
    //create dynamic finders for the fields

    Jogo findByNome(String nome);

    Jogo findByGenero(String genero);

    Jogo findByPlataforma(String plataforma);
}
