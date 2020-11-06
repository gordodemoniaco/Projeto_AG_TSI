package projeto_ag;

import java.util.ArrayList;
import java.util.Iterator;

public class AlgoritimoGenetico {
    private int populacao;  // tamanho da populacao
    private int geracoes;   // numero de gerações
    private double mutacao; // taxa de mutação (0.0 pra 0% e 1.0 pra 100%)
    private int elitismo;   // quantudade de individuos eleitos por elitismo
    private boolean selecao; // true = roleta | false = torneio
    private Grafo grafo;    // Grafo que será passado por parâmetro

    AlgoritimoGenetico(int populacao, int geracoes, double mutacao, int elitismo, boolean selecao, Grafo grafo, int corte){
        this.populacao = populacao;
        this.geracoes = geracoes;
        this.elitismo = elitismo;
        this.grafo = grafo;
        this.mutacao = mutacao;
        this.selecao = selecao;
    }
}
