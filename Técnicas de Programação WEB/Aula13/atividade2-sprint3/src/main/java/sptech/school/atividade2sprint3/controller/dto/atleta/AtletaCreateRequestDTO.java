package sptech.school.atividade2sprint3.controller.dto.atleta;

import lombok.Data;
import sptech.school.atividade2sprint3.entity.Equipe;

@Data
public class AtletaCreateRequestDTO {
    private String nome;
    private Integer idade;
    private String posicao;
    private Integer idEquipe;
}
