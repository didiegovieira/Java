package sptech.school.atividadevalidation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 30)
    private String titulo;

    @NotBlank
    private String diretor;

    @Past
    private LocalDate dataLancamento;

    @DecimalMin(value = "1.0")
    private Double duracao;

    @DecimalMin(value = "1.0")
    @DecimalMax(value = "10.0")
    private Double nota;

    @Min(1)
    @Max(100)
    private Integer ranking;

    public Filme() {

    }

    public Filme(Integer id, String titulo, String diretor, LocalDate dataLancamento, Double duracao, Double nota, Integer ranking) {
        this.id = id;
        this.titulo = titulo;
        this.diretor = diretor;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.nota = nota;
        this.ranking = ranking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", diretor='" + diretor + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", duracao=" + duracao +
                ", nota=" + nota +
                ", ranking=" + ranking +
                '}';
    }
}
