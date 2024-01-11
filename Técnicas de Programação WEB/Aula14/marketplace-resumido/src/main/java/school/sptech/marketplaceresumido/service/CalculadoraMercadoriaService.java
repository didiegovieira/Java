package school.sptech.marketplaceresumido.service;

public class CalculadoraMercadoriaService {
    public Double calculaICMS(Double valorMercadoria) {
        if (valorMercadoria == null) {
            throw new IllegalArgumentException("Valor da mercadoria não pode ser nulo");
        }

        if (valorMercadoria == 0.0) {
            throw new IllegalArgumentException("Valor da mercadoria não pode ser zero");
        }

        if (valorMercadoria < 0.0) {
            throw new IllegalArgumentException("Valor da mercadoria não pode ser negativo");
        }

        return valorMercadoria * 0.18;
    }
}
