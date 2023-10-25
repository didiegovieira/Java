package sptech.school.relacionamento1.dto.consulta;

import jakarta.persistence.OneToMany;
import lombok.Data;
import sptech.school.relacionamento1.entity.Consulta;

import java.util.List;

@Data
public class MedicoConsultaResponseDto {
    private Integer id;
    private String crm; // numero Conselho Regional Medicina
    private String nome;
    private String especialidade;

    private List<ConsultaMedicoResponseDto> consultas;

    public void setConsultas(List<Consulta> consultas) {
    }
}
