package Class;

public class AlunoPos extends Aluno{
    private Double nota1;
    private Double nota2;
    private Double notaMonografia;

    public AlunoPos(Integer ra, String nome, Double nota1, Double nota2, Double notaMonografia) {
        super(ra, nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaMonografia = notaMonografia;
    }

    @Override
    public Double calculaMedia() {
        return (nota1+nota2+notaMonografia)/3;
    }

    @Override
    public String toString() {
        return String.format(
                "Aluno Pos:\nNome: %s\nRa: %d\nNota1: %.2f\nNota2: %.2f" +
                        "\nNota Monografia: %.2f\nNota Media: %.2f\n",
                getNome(), getRa(), nota1, nota2, notaMonografia, calculaMedia());
    }
}
