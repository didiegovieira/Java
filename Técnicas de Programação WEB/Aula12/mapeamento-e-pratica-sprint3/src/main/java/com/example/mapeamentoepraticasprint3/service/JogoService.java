package com.example.mapeamentoepraticasprint3.service;

import com.example.mapeamentoepraticasprint3.repository.EmpresaRepository;
import com.example.mapeamentoepraticasprint3.repository.JogoRepository;
import org.springframework.stereotype.Service;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

}