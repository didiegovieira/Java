package school.sptech.atividade1.controller.dto.mapper;

import school.sptech.atividade1.controller.dto.UsuarioCreateRequestDto;
import school.sptech.atividade1.controller.dto.UsuarioResponseDto;
import school.sptech.atividade1.controller.dto.UsuarioSimpleResponse;
import school.sptech.atividade1.entity.Usuario;

import java.util.List;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioCreateRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Usuario entity = new Usuario();

        entity.setNome(dto.getNome());
        entity.setSobrenome(dto.getSobrenome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setDataNascimento(dto.getDataNascimento());

        return entity;
    }

    public static UsuarioResponseDto toUsuarioReponseDto(Usuario entity) {
        if (entity == null) {
            return null;
        }

        UsuarioResponseDto dto = new UsuarioResponseDto();
        dto.setId(entity.getId());
        dto.setNomeCompleto(entity.getNome() + " " + entity.getSobrenome());
        dto.setDocumento(entity.getCpf());
        dto.setContato(entity.getEmail());
        dto.setDataNascimento(entity.getDataNascimento());

        return dto;
    }

    public static UsuarioSimpleResponse toUsuarioSimpleResponse(Usuario entity) {
        UsuarioSimpleResponse dto = new UsuarioSimpleResponse();

        dto.setId(entity.getId());
        dto.setNomeCompleto(entity.getNome() + " " + entity.getSobrenome());

        return dto;
    }
}
