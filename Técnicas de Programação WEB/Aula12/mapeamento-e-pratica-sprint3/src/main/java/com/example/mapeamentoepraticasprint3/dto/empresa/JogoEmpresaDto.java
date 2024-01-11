package com.example.mapeamentoepraticasprint3.dto.empresa;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JogoEmpresaDto {
    private Integer id;

    private String nome;

    private String genero;

    private String plataforma;

    private LocalDateTime dataLancamento;
}
