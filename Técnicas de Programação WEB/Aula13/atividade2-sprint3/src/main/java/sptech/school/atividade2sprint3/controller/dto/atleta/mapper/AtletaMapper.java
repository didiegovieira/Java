package sptech.school.atividade2sprint3.controller.dto.atleta.mapper;

import sptech.school.atividade2sprint3.controller.dto.atleta.AtletaCreateRequestDTO;
import sptech.school.atividade2sprint3.controller.dto.atleta.AtletaResponseDTO;
import sptech.school.atividade2sprint3.controller.dto.atleta.AtletaSimpleResponseDTO;
import sptech.school.atividade2sprint3.controller.dto.atleta.EquipeResponseDTO;
import sptech.school.atividade2sprint3.controller.dto.equipe.mapper.EquipeMapper;
import sptech.school.atividade2sprint3.entity.Atleta;
import sptech.school.atividade2sprint3.entity.Equipe;

import java.util.List;

public class AtletaMapper {
    public static AtletaResponseDTO toAtletaResponseDto(Atleta atleta) {
        if (atleta == null) {
            return null;
        }

        AtletaResponseDTO atletaReponseDTO = new AtletaResponseDTO();

        atletaReponseDTO.setId(atleta.getId());
        atletaReponseDTO.setNome(atleta.getNome());
        atletaReponseDTO.setIdade(atleta.getIdade());
        atletaReponseDTO.setPosicao(atleta.getPosicao());
        atletaReponseDTO.setEquipe(toEquipeResponseDto(atleta.getEquipe()));

        return atletaReponseDTO;
    }

    public static EquipeResponseDTO toEquipeResponseDto(Equipe equipe) {
        if (equipe == null) {
            return null;
        }

        EquipeResponseDTO equipeResponseDTO = new EquipeResponseDTO();

        equipeResponseDTO.setId(equipe.getId());
        equipeResponseDTO.setNome(equipe.getNome());
        equipeResponseDTO.setNomeDoTecnico(equipe.getNomeDoTecnico());

        return equipeResponseDTO;
    }

    public static AtletaSimpleResponseDTO toAtletaSimpleResponseDto(Atleta atleta) {
        if (atleta == null) {
            return null;
        }

        AtletaSimpleResponseDTO atletaSimpleResponseDTO = new AtletaSimpleResponseDTO();

        atletaSimpleResponseDTO.setId(atleta.getId());
        atletaSimpleResponseDTO.setNome(atleta.getNome());

        return atletaSimpleResponseDTO;
    }

    public static Atleta toEntity(AtletaCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Atleta entity = new Atleta();

        entity.setNome(dto.getNome());
        entity.setIdade(dto.getIdade());
        entity.setPosicao(dto.getPosicao());

        Equipe equipe = new Equipe();
        equipe.setId(dto.getIdEquipe());
        entity.setEquipe(equipe);

        return entity;
    }


}