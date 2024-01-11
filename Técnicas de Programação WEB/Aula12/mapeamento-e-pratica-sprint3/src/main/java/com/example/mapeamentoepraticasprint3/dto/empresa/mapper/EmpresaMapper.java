package com.example.mapeamentoepraticasprint3.dto.empresa.mapper;

import com.example.mapeamentoepraticasprint3.dto.empresa.EmpresaJogoDto;
import com.example.mapeamentoepraticasprint3.dto.empresa.JogoEmpresaDto;
import com.example.mapeamentoepraticasprint3.entity.Empresa;
import com.example.mapeamentoepraticasprint3.entity.Jogo;

import java.util.List;

public class EmpresaMapper {
    public static EmpresaJogoDto toEmpresaJogoDto(Empresa empresa) {
        if (empresa == null) {
            return null;
        }

        EmpresaJogoDto empresaJogoDto = new EmpresaJogoDto();

        empresaJogoDto.setId(empresa.getId());
        empresaJogoDto.setNome(empresa.getNome());
        empresaJogoDto.setCnpj(empresa.getCnpj());
        empresaJogoDto.setEndereco(empresa.getEndereco());
        empresaJogoDto.setTelefone(empresa.getTelefone());
        empresaJogoDto.setEmail(empresa.getEmail());

        if (empresa.getJogos().isEmpty()) {
            List<Jogo> jogos = empresa.getJogos();

            List<JogoEmpresaDto> jogosEmpresaDto = jogos.stream()
                    .map(EmpresaMapper::toJogoEmpresaDto)
                    .toList();

            empresaJogoDto.setJogos(jogosEmpresaDto);
        }

        return empresaJogoDto;
    }

    public static JogoEmpresaDto toJogoEmpresaDto(Jogo jogo) {
            if (jogo == null) {
                return null;
            }

            JogoEmpresaDto jogoEmpresaDto = new JogoEmpresaDto();

            jogoEmpresaDto.setId(jogo.getId());
            jogoEmpresaDto.setNome(jogo.getNome());
            jogoEmpresaDto.setGenero(jogo.getGenero());
            jogoEmpresaDto.setPlataforma(jogo.getPlataforma());
            jogoEmpresaDto.setDataLancamento(jogo.getDataLancamento());

            return jogoEmpresaDto;
    }
}
