package sptech.school.relacionamento1.dto.medico.mapper;

import sptech.school.relacionamento1.dto.consulta.MedicoConsultaResponseDto;
import sptech.school.relacionamento1.dto.medico.ConsultaMedicoDto;
import sptech.school.relacionamento1.dto.medico.MedicoConsultaDto;
import sptech.school.relacionamento1.entity.Consulta;
import sptech.school.relacionamento1.entity.Medico;

public class MedicoMapper {
    public static MedicoConsultaDto toMedicoConsultaDto(Medico medicoEntidade) {
        if (medicoEntidade == null) {
            return null;
        }

        MedicoConsultaDto medicoConsultaDto = new MedicoConsultaDto();

        medicoConsultaDto.setId(medicoEntidade.getId());
        medicoConsultaDto.setNome(medicoEntidade.getNome());
        medicoConsultaDto.setCrm(medicoEntidade.getCrm());
        medicoConsultaDto.setEspecialidade(medicoEntidade.getEspecialidade());

    }

    public static ConsultaMedicoDto toConsultaDto(Consulta consultaEntidade) {

    }
}
