package projeto_ag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class AlgoritimoGenetico {
    private int populacao;  // tamanho da populacao
    private int geracoes;   // numero de gerações
    private double mutacao; // taxa de mutação (0.0 pra 0% e 1.0 pra 100%)
    private int elitismo;   // quantudade de individuos eleitos por elitismo
    private boolean selecao; // true = roleta | false = torneio
    private Grafo grafo;    // Grafo que será passado por parâmetro
    private ArrayList<String> nomes = new ArrayList<>();
    private ArrayList<Individuo> resultados = new ArrayList<>();
    private int contador_nomes;
    private int contador_geracao;

    AlgoritimoGenetico(int populacao, int geracoes, double mutacao, int elitismo, boolean selecao, Grafo grafo, int corte){
        this.populacao = populacao;
        this.geracoes = geracoes;
        this.elitismo = elitismo;
        this.grafo = grafo;
        this.mutacao = mutacao;
        this.selecao = selecao;
        this.contador_nomes = 1;
        this.contador_geracao = 0;

    }
    public void executarGeracao(){

    }
    public Individuo execMutacao(Individuo p, Grafo g){
        int tamanho = p.tamanhoIndividuo(g);
        Individuo f = p;
        if(tamanho == 2){
            return f;
        }
        if(tamanho == 3){
            int []temp = f.getGenotipo();
            Random r = new Random();
            int aux1;
            do{
                aux1 = r.nextInt(g.n-1);
            }while(aux1==g.getInicio() || aux1==g.getFim());
            temp[1] = aux1;
            f.setGenotipo(temp);
            return f;
            
        }
        else{
            int []temp = f.getGenotipo();
            Random r = new Random();
            int aux1=tamanho-1;
            int aux2=1;
            do{
                aux1 = r.nextInt(tamanho-1);
                aux2 = r.nextInt(tamanho-1);
            }while((aux1==aux2) || (aux1==0 || aux2==0));
            int temporario = temp[aux1];
            temp[aux1] = temp[aux2];
            temp[aux2] = temporario;
            f.setGenotipo(temp);
            return f;
        }
    }
}
