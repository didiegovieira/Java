package school.sptech.atividade1.controller.dto;

import lombok.*;

import java.time.LocalDate;

//FIXME: Completar a classe
@Data
public class UsuarioCreateRequestDto {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;

}
