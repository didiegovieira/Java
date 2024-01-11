package sptech.school.atividade2sprint3.controller.dto.atleta;

import lombok.Data;

@Data
public class AtletaSimpleResponseDTO {
    private Integer id;
    private String nome;
    private Integer idade;
    private String posicao;
    private Integer idEquipe;
}
