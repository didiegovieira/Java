package demo.exerciciolivraria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 3)
  private String titulo;

  @NotBlank
  @Size(min = 3)
  private String autor;

  @PastOrPresent
  private LocalDate dataPublicacao;

  @PositiveOrZero
  private Double preco;

  private boolean disponibilidadeEstoque;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public LocalDate getDataPublicacao() {
    return dataPublicacao;
  }

  public void setDataPublicacao(LocalDate dataPublicacao) {
    this.dataPublicacao = dataPublicacao;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public boolean isDisponibilidadeEstoque() {
    return disponibilidadeEstoque;
  }

  public void setDisponibilidadeEstoque(boolean disponibilidadeEstoque) {
    this.disponibilidadeEstoque = disponibilidadeEstoque;
  }
}
