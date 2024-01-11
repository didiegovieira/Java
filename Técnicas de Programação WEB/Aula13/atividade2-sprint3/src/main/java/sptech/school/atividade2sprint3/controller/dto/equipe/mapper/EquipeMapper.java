package sptech.school.atividade2sprint3.controller.dto.equipe.mapper;

import sptech.school.atividade2sprint3.controller.dto.equipe.AtletaResponseDTO;
import sptech.school.atividade2sprint3.controller.dto.equipe.EquipeCreateRequestDTO;
import sptech.school.atividade2sprint3.controller.dto.equipe.EquipeResponseDTO;
import sptech.school.atividade2sprint3.controller.dto.equipe.EquipeSimpleResponseDTO;
import sptech.school.atividade2sprint3.entity.Atleta;
import sptech.school.atividade2sprint3.entity.Equipe;

import java.util.List;

public class EquipeMapper {
    public static EquipeResponseDTO toEquipeResponseDto(Equipe equipe) {
        if (equipe == null) {
            return null;
        }

        EquipeResponseDTO equipeResponseDTO = new EquipeResponseDTO();

        equipeResponseDTO.setId(equipe.getId());
        equipeResponseDTO.setNome(equipe.getNome());
        equipeResponseDTO.setNomeDoTecnico(equipe.getNomeDoTecnico());

        List<Atleta> atletas = equipe.getAtletas();
        List<AtletaResponseDTO> atletaReponseDtos = atletas.stream()
                .map(EquipeMapper::toAtletaResponseDto)
                .toList();

        equipeResponseDTO.setAtletas(atletaReponseDtos);

        return equipeResponseDTO;
    }

    public static AtletaResponseDTO toAtletaResponseDto(Atleta atleta) {
        if (atleta == null) {
            return null;
        }

        AtletaResponseDTO atletaReponseDTO = new AtletaResponseDTO();

        atletaReponseDTO.setId(atleta.getId());
        atletaReponseDTO.setNome(atleta.getNome());
        atletaReponseDTO.setIdade(atleta.getIdade());
        atletaReponseDTO.setPosicao(atleta.getPosicao());

        return atletaReponseDTO;
    }

    public static Equipe toEntity(EquipeCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Equipe entity = new Equipe();

        entity.setNome(dto.getNome());
        entity.setNomeDoTecnico(dto.getNomeDoTecnico());

        return entity;
    }

    public static EquipeSimpleResponseDTO toEquipeSimpleResponse(Equipe entity) {
        EquipeSimpleResponseDTO dto = new EquipeSimpleResponseDTO();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNomeDoTecnico(entity.getNomeDoTecnico());

        return dto;
    }
}
