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
        Scanner entrada = new Scanner (System.in);
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
        System.out.println("O Grafo:");
        g.imprimegrafo();
        entrada.close();
    }
}

