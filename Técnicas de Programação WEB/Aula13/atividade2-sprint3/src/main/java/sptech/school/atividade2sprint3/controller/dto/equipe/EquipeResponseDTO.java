package sptech.school.atividade2sprint3.controller.dto.equipe;

import lombok.Data;

import java.util.List;

@Data
public class EquipeResponseDTO {
    private Integer id;
    private String nome;
    private String nomeDoTecnico;
    private List<AtletaResponseDTO> atletas;
}
