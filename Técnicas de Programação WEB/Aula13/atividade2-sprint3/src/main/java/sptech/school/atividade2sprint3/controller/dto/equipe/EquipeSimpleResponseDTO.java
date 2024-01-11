package sptech.school.atividade2sprint3.controller.dto.equipe;

import lombok.Data;

@Data
public class EquipeSimpleResponseDTO {
    private Integer id;
    private String nome;
    private String nomeDoTecnico;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeDoTecnico() {
        return nomeDoTecnico;
    }
}
