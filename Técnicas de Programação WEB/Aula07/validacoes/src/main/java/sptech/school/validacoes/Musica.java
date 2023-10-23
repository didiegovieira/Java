package sptech.school.validacoes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Musica {
    @Id // -> CHAVE PRIMARIA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // -> AUTO INCREMENTO
    private Integer id;


    @NotBlank
    private String nome;


    @Size(min = 3, max = 10)
    @NotBlank
    private String album;


    @NotBlank
    @Past
    @PastOrPresent
    @Future
    @FutureOrPresent
    private LocalDate dataLancamento;


    @NotBlank
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "5.0")
    private Double nota;


    @Min(1)
    private Integer ranking;

    @Email(regexp = "") //@
    private String email;


    @Pattern(regexp = "")
    private String phoneNumber;


    @CPF
    private String cpfResponsavel;

    @CNPJ
    private String cnpjProdutora;

    public Musica() {

    }

    public Musica(Integer id, String nome, String album, LocalDate dataLancamento, Double nota, Integer ranking) {
        this.id = id;
        this.nome = nome;
        this.album = album;
        this.dataLancamento = dataLancamento;
        this.nota = nota;
        this.ranking = ranking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
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
        return "Musica{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", album='" + album + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", nota=" + nota +
                ", ranking=" + ranking +
                '}';
    }
}
