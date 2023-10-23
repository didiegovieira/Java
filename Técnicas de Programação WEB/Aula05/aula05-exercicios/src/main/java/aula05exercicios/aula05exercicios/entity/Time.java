package aula05exercicios.aula05exercicios.entity;

public class Time {
    private String nome;
    private String treinador;
    private int vitorias;
    private int derrotas;
    private int empates;

    public Time() {

    }

    public Time(String nome, String treinador, int vitorias, int derrotas, int empates) {
        this.nome = nome;
        this.treinador = treinador;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTreinador() {
        return treinador;
    }

    public void setTreinador(String treinador) {
        this.treinador = treinador;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getPontuacaoTotal() {
        return (vitorias * 3 ) + empates;
    }

    public Double getAproveitamento() {
        double pontuacaoPossivel = (empates+derrotas+vitorias) * 3.0;
        if (pontuacaoPossivel == 0.0) {
            return 0.0;
        }
        return (getPontuacaoTotal() / pontuacaoPossivel) * 100;
    }
}
