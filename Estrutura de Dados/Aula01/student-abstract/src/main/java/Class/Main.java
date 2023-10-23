package Class;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlunoGraduacao alunoGraduacao =
                new AlunoGraduacao(1222015, "Diego", 5.50, 8.00);
        AlunoFundamental alunoFundamental =
                new AlunoFundamental(1222016, "Diego2", 5.0, 2.0, 8.0, 10.0);
        AlunoPos alunoPos =
                new AlunoPos(1222017, "Diego3", 10.0, 5.0, 7.0);

        Escola escola = new Escola("SPTech", new ArrayList<Aluno>());

        escola.adicionaAluno(alunoGraduacao);
        escola.adicionaAluno(alunoFundamental);
        escola.adicionaAluno(alunoPos);

        escola.exibeTodos();

        escola.exibeAlunosGraduacao();

        escola.exibeAprovados();

        escola.buscaAluno(1222018);

    }
}
