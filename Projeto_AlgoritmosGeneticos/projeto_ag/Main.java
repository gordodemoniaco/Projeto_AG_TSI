package projeto_ag;

import java.util.Scanner;

/**
 * Método Principal do Projeto de Algorítmos Genéticos
 * Projeto sobre Grafos não-dirigidos
 *
 * @author Thomas Adam da Costa
 */

public class Main {
    public static void main(String[] args) {
        final int geracoes = 20; // número de gerações
        int populacao=1000; // tamanho da populacao
        double mutacao = 0.05; // (0 (0%) a 1(100%))
        boolean selecao = false; // true=roleta | false=torneio 
        int elitismo = 10; // numero de individuos para eleitismo
        int corte = 3;  // posicao de corte do crossover padrao ([2])
        
        Grafo g; // instancia do grafo
        
        System.out.println("Projeto Algorítmos Genéticos");
        System.out.println("");
        System.out.println("Número de Gerações definido: "+ geracoes); // numero de gerações impresso
        int op = 2; // opcao de grafo
        g = new Grafo(op);
        g.definepontas();
        System.out.println("Tamanho de População: "+ populacao);
        System.out.println("Membros de Elite: "+ elitismo);
        System.out.println("Taxa de Mutação: "+ mutacao);
        System.out.println("Método de Seleção: "+ g.printSelecao(selecao));
        corte = g.posicaoCorte();
        //a = new AlgoritimoGenetico(populacao, geracoes, mutacao, elitismo, selecao, g, corte);
    }
}

