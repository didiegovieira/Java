package com.example.mapeamentoepraticasprint3.dto.empresa;

import lombok.Data;

import java.util.List;

@Data
public class EmpresaJogoDto {
    private Integer id;

    private String nome;

    private String cnpj;

    private String endereco;

    private String telefone;

    private String email;

    private List<JogoEmpresaDto> jogos;
}
