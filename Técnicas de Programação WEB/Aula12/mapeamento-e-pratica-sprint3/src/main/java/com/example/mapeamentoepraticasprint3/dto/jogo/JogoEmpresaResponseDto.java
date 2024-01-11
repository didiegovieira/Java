package com.example.mapeamentoepraticasprint3.dto.jogo;

import java.time.LocalDateTime;

public class JogoEmpresaResponseDto {
    private Integer id;

    private String nome;

    private String genero;

    private String plataforma;

    private LocalDateTime dataLancamento;

    private EmpresaJogoResponseDto empresa;
}
