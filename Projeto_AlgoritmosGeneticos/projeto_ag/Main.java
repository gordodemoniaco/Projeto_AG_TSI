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
        int aleatorio = 0;
        int n = 6;
        Grafo g;
        final int geracoes = 20; // número de gerações
        int populacao = 1000; // tamanho da populacao
        double mutacao = 0.05; // (0 (0%) a 1(100%))
        boolean selecao = false; // true=roleta | false=torneio 
        int elitismo = 10; // numero de individuos para eleitismo
        int corte = 3;  // posicao de corte do crossover padrao ([2])
        Scanner entrada = new Scanner (System.in);
        String auxiliar;
        AlgoritimoGenetico a;
        System.out.println("Projeto Algorítmos Genéticos");
        System.out.println("");
        System.out.println("");
        System.out.println("Configuração do Grafo:");
        System.out.println("");
        System.out.println("1 - Montar Grafo");
        System.out.println("2 - Grafo Padrão");
        System.out.println("Opção:");
        int op = entrada.nextInt();
        if(op==1){
            System.out.println("Opção '1 - Montar Grafo' Escolhida");
            System.out.println("Escolha o numero de Vértices do grafo:");
            n = Integer.valueOf(entrada.nextInt());
            System.out.println("Digite '1' para Grafo Aleatório e '0' para montar o Grafo:");
            aleatorio = entrada.nextInt();
            
            g = new Grafo(n, aleatorio);
        }
        else{
            System.out.println("Opção '2 - Grafo Padrão' Escolhida");
            g = new Grafo();
        }
        g.definepontas();
        //System.out.println("O Grafo:");
        //g.imprimegrafo();
        System.out.println("Número de Gerações definido: 20"); // numero de gerações impresso

        System.out.println("Tamanho da População: "); // Obter valor da população
        auxiliar = entrada.nextLine();
        populacao = Integer.valueOf(auxiliar);
        System.out.println("Tamanho de População Escolhido: "+ populacao);

        System.out.println("Membros de Elitismo: "); // Obter numero de membros com elitismo
        auxiliar = entrada.nextLine();
        elitismo = Integer.valueOf(auxiliar);
        System.out.println("Membros de Elite: "+ elitismo+"/"+populacao);
        do{
            System.out.println("Taxa de Mutação (entre 0 e 1): "); // Obter taxa de mutação
            auxiliar = entrada.nextLine();
            mutacao = Double.valueOf(auxiliar);
        }while(mutacao<0.0 && mutacao>1.0);
        System.out.println("Taxa de Mutação: "+ mutacao);

        System.out.println("Método de Seleção: "); // Selecionar método de Seleçao
        System.out.println("Torneio | Roleta "); // Selecionar método de Seleçao
        System.out.println("Opçao: "); // Selecionar método de Seleçao
        auxiliar = entrada.nextLine();
        if(auxiliar=="Roleta"|| auxiliar=="roleta")
            selecao = true; // escolhido roleta = true
        else
            selecao = false;
        System.out.println("Método de Seleção Escolhido: "+ g.printSelecao(selecao));
        corte = g.posicaoCorte();
        System.out.println("Posição do Corte:"+ corte);
        
        a = new AlgoritimoGenetico(populacao, geracoes, mutacao, elitismo, selecao, g, corte);
        entrada.close();
    }
}

