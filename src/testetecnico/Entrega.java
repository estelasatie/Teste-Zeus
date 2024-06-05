package testetecnico;

import java.util.ArrayList;
import java.util.List;

class Veiculo {
    String nome;
    double velocidade;
    double carga;
    double largura;
    double profundidade;
    double altura;

    public Veiculo(String nome, double velocidade, double carga, double largura, double profundidade, double altura) {
        this.nome = nome;
        this.velocidade = velocidade;
        this.carga = carga;
        this.largura = largura;
        this.profundidade = profundidade;
        this.altura = altura;
    }

    public boolean capacidade(double peso, double largura, double profundidade, double altura) {
        return this.carga >= peso && this.largura >= largura && this.profundidade >= profundidade && this.altura >= altura;
    }

    public double tempo(double distancia) {
        return distancia / this.velocidade;
    }
}

class Motorista {
    String nome;
    List<Veiculo> carros;
    List<Veiculo> caminhoes;
    List<Veiculo> motocicletas;

    public Motorista(String nome, List<Veiculo> carros, List<Veiculo> caminhoes, List<Veiculo> motocicletas) {
        this.nome = nome;
        this.carros = carros;
        this.caminhoes = caminhoes;
        this.motocicletas = motocicletas;
    }
}

public class Entrega {
    public static void main(String[] args) {
        // inicializando os dDOS
        List<Motorista> motoristas = new ArrayList<>();

        List<Veiculo> carrosMaria = new ArrayList<>();
        carrosMaria.add(new Veiculo("Fiorino", 50, 150, 0.5, 1.0, 0.4));
        List<Veiculo> caminhoesMaria = new ArrayList<>();
        caminhoesMaria.add(new Veiculo("Volvo", 40, 10000, 2.0, 6.0, 2.2));
        List<Veiculo> motocicletasMaria = new ArrayList<>();
        motocicletasMaria.add(new Veiculo("Fazer 250", 70, 10, 0.5, 0.5, 0.5));
        motoristas.add(new Motorista("Maria", carrosMaria, caminhoesMaria, motocicletasMaria));

        List<Veiculo> carrosJoao = new ArrayList<>();
        carrosJoao.add(new Veiculo("Uno", 60, 100, 0.5, 1.0, 0.4));
        List<Veiculo> caminhoesJoao = new ArrayList<>();
        caminhoesJoao.add(new Veiculo("Scania", 45, 10000, 2.0, 6.0, 2.2));
        List<Veiculo> motocicletasJoao = new ArrayList<>();
        motocicletasJoao.add(new Veiculo("Honda Biz", 55, 10, 0.5, 0.5, 0.5));
        motoristas.add(new Motorista("Joao", carrosJoao, caminhoesJoao, motocicletasJoao));

        // atributos da encomenda
        double pesoEncomenda = 10;
        double larguraEncomenda = 0.5;
        double profundidadeEncomenda = 0.5;
        double alturaEncomenda = 0.75;
        //exemplo de distancia
        double distancia = 500;

        // Procura o melhor veículo
        for (Motorista motorista : motoristas) {
            Veiculo melhorVeiculo = null;
            double menorTempo = Double.MAX_VALUE;

            for (Veiculo carro : motorista.carros) {
                if (carro.capacidade(pesoEncomenda, larguraEncomenda, profundidadeEncomenda, alturaEncomenda)) {
                    double tempo = carro.tempo(distancia);
                    if (tempo < menorTempo) {
                        menorTempo = tempo;
                        melhorVeiculo = carro;
                    }
                }
            }

            for (Veiculo caminhao : motorista.caminhoes) {
                if (caminhao.capacidade(pesoEncomenda, larguraEncomenda, profundidadeEncomenda, alturaEncomenda)) {
                    double tempo = caminhao.tempo(distancia);
                    if (tempo < menorTempo) {
                        menorTempo = tempo;
                        melhorVeiculo = caminhao;
                    }
                }
            }

            for (Veiculo motocicleta : motorista.motocicletas) {
                if (motocicleta.capacidade(pesoEncomenda, larguraEncomenda, profundidadeEncomenda, alturaEncomenda)) {
                    double tempo = motocicleta.tempo(distancia);
                    if (tempo < menorTempo) {
                        menorTempo = tempo;
                        melhorVeiculo = motocicleta;
                    }
                }
            }

            if (melhorVeiculo != null) {
                System.out.println("O(a) " + motorista.nome + " deve usar o veículo " + melhorVeiculo.nome + " para entregar a encomenda no menor tempo possível.");
            } else {
                System.out.println("O(A) " + motorista.nome + " não possui veículo p/ entregar a encomenda.");
            }
        }
    }
}

