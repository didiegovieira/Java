package Class;

import java.util.ArrayList;
import java.util.List;

public class Escola {
    private String nome;
    private List<Aluno> list;

    public Escola(String nome, List<Aluno> list) {
        this.nome = nome;
        this.list = new ArrayList<Aluno>();
    }

    public void adicionaAluno(Aluno a){
        System.out.println(String.format("Adicionando o aluno: %s", a.getNome()));
        list.add(a);
    }

    public void exibeTodos(){
        System.out.println(String.format("\nExibindo todos os alunos: \n %s", list));
    }

    public void exibeAlunosGraduacao(){
        System.out.println("\nExibindo apenas os alunos graduação:");
        for (Aluno a : list){
            if (a instanceof AlunoGraduacao){
                System.out.println(a);
            }
        }
    }

    public void exibeAprovados(){
        System.out.println("\nExibindo apenas os alunos aprovados:");
        for (Aluno a : list){
            if (a.calculaMedia() >= 6.0){
                System.out.println(a);
            }
        }
    }

    public void buscaAluno(Integer ra){
        System.out.println("\nExibindo apenas o aluno do RA especificado:\n");
        for (Aluno a : list) {
            if (a.getRa().equals(ra)) {
                System.out.println(a);
            }
        }

        System.out.println("Aluno não encontrado!");
    }

    @Override
    public String toString() {
        return String.format("\nEscola: %s\nAlunos Matriculados: %s", nome, list);
    }
}
