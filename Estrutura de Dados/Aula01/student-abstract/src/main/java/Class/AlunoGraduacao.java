package Class;

public class AlunoGraduacao extends Aluno{
    private Double nota1;
    private Double nota2;

    public AlunoGraduacao(Integer ra, String nome, Double nota1, Double nota2) {
        super(ra, nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    @Override
    public Double calculaMedia() {
        return (nota1 * 0.4) + (nota2 * 0.6);
    }

    @Override
    public String toString() {
        return String.format(
                "Aluno Graduação:\nNome: %s\nRa: %d\nNota1: %.2f\nNota2: %.2f\nNota Media: %.2f\n",
                getNome(), getRa(), nota1, nota2, calculaMedia());
    }
}
