package school.sptech.marketplaceresumido.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProdutoCriacaoDto {

    @NotBlank
    @Size(min = 3)
    private String nome;

    @Size(min = 10, max = 255)
    private String descricao;

    @DecimalMin("0.50")
    private Double preco;

    @Size(min = 10, max = 255)
    private String codigoBarra;

    public ProdutoCriacaoDto() {
    }

    public ProdutoCriacaoDto(String nome, String descricao, Double preco, String codigoBarra) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.codigoBarra = codigoBarra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
}