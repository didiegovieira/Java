package sptech.school.relacionamento1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String crm; // numero Conselho Regional Medicina
    private String nome;
    private String especialidade;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;
}
