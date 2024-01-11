package org.example;

public class Repositorio {
    private ListaObj<PersonagemLivro> lista;
    private PilhaObj<PersonagemLivro> pilha;

    private FilaObj<PersonagemLivro> fila;

    public Repositorio(Integer tamanho) {
        lista = new ListaObj<>(tamanho);
        pilha = new PilhaObj<>(tamanho);
        fila = new FilaObj<>(tamanho);
    }

    public void salvar(PersonagemLivro objeto) {
        lista.adiciona(objeto);
        pilha.push(objeto);
        fila.insert(objeto);
    }

    public void deletar(int id) {
        PersonagemLivro objetoParaRemover = null;

        for (int i = 0; i < lista.getTamanho(); i++) {
            PersonagemLivro personagem = lista.getElemento(i);
            if (personagem.getId() == id) {
                objetoParaRemover = personagem;
                break;
            }
        }

        if (objetoParaRemover != null) {
            lista.removeElemento(objetoParaRemover);
        } else {
            System.out.println("ID inexistente");
        }
    }

    public void exibir() {
        if (lista.isEmpty()) {
            System.out.println("Repositório vazio");
        } else {
            System.out.println("Conteúdo da lista:");
            for (int i = 0; i < lista.getTamanho(); i++) {
                PersonagemLivro personagem = lista.getElemento(i);
                System.out.println(personagem);
            }
        }

        pilha.exibe();
    }

    public void desfazer() {
        if (pilha.isEmpty()) {
            System.out.println("Não há nada a desfazer");
        } else {
            PersonagemLivro objetoParaDesfazer = pilha.pop();
            deletar(objetoParaDesfazer.getId());
            System.out.println("Operação desfeita para o ID: " + objetoParaDesfazer.getId());
        }
    }

    public void agendarSalvar(PersonagemLivro objeto) {
        fila.insert(objeto);
    }

    public void executarAgendado(int qtdOperacoes) {
        if (fila.isEmpty()) {
            System.out.println("Não há operações agendadas");
        } else {
            if (qtdOperacoes <= 0 || qtdOperacoes > fila.getTamanho()) {
                System.out.println("Quantidade inválida");
            } else {
                for (int i = 0; i < qtdOperacoes; i++) {
                    salvar(fila.poll());
                }
            }
        }
    }
}
