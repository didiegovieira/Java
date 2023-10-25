package sptech.school.relacionamento1.dto.consulta;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import sptech.school.relacionamento1.entity.Medico;

import java.time.LocalDateTime;

@Data
public class ConsultaMedicoResponseDto {
    private Integer id;
    private String nomePaciente;
    private LocalDateTime dataHora;
    private String status;

    private MedicoConsultaResponseDto medico;  //  medico_id
}
