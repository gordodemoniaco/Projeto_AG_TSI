package projeto_ag;


/**
 * Método Principal do Projeto de Algorítmos Genéticos
 * Projeto sobre Grafos não-dirigidos
 *
 * @author Thomas Adam da Costa
 */

public class Main {
    public static void main(String[] args) {
        final int geracoes = 20; // número de gerações
        int populacao=10; // tamanho da populacao
        double mutacao = 0.01; // (0 (0%) a 1(100%))
        boolean selecao = false; // true=roleta | false=torneio
        int combatentes = 2; // numero de combatentes
        int elitismo = 1; // numero de individuos para eleitismo

        Grafo grafo; // instancia do grafo
        int ponta_inicio = 0;
        int ponta_final = 5;
        AlgoritimoGenetico a; // instancia do algoritmo
        
        System.out.println("Projeto Algorítmos Genéticos");
        System.out.println("");
        System.out.println("Número de Gerações definido: "+ geracoes); // numero de gerações impresso
        int vertices = 10; // opcao de grafo, definido estaticamente
        grafo = new Grafo(vertices); // instancia do grafo
        grafo.setInicioFim(ponta_inicio, ponta_final); // define os vertices de inicio em fim do grafo
        System.out.println("Tamanho de População: "+ populacao); // tamanho da populacao impresso
        System.out.println("Membros de Elite: "+ elitismo);
        System.out.println("Taxa de Mutação: "+ mutacao);
        System.out.println("Método de Seleção: "+ grafo.printSelecao(selecao));
        a = new AlgoritimoGenetico(populacao, geracoes, mutacao, elitismo, selecao, combatentes, grafo);
        a.executar();
    }
}

