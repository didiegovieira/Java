package school.sptech.atividade1.controller.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;

//FIXME: Completar a classe
@Data
public class UsuarioResponseDto {

    //FIXME: Implementar lógica para calcular a idade
    private Integer id;
    private String nomeCompleto;
    private String documento;
    private LocalDate dataNascimento;
    private String contato;

    public int getIdade() {
        LocalDate atual = LocalDate.now();
        return Period.between(dataNascimento, atual).getYears();
    }

}
