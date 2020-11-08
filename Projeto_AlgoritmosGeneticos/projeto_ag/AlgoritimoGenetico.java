package projeto_ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class AlgoritimoGenetico {
    private int populacao;  // tamanho da populacao
    private int geracoes;   // numero de gerações
    private int mutacao; // taxa de mutação (0.0 pra 0% e 1.0 pra 100%)
    private int elitismo;   // quantudade de individuos eleitos por elitismo
    private boolean selecao; // true = roleta | false = torneio
    private Grafo grafo;    // Grafo que será passado por parâmetro
    private ArrayList<String> nomes_escolhidos = new ArrayList<>();
    private ArrayList<Individuo> originais = new ArrayList<>();
    private int contador_nomes;
    private int contador_geracao;
    private static int multipli = 10000;

    AlgoritimoGenetico(int populacao, int geracoes, double mutacao, int elitismo, boolean selecao, Grafo grafo, int corte){
        this.populacao = populacao;
        this.geracoes = geracoes;
        this.elitismo = elitismo;
        this.grafo = grafo;
        this.mutacao = (int) mutacao*multipli;
        this.selecao = selecao;
        this.contador_nomes = 1;
        this.contador_geracao = 0;

    }
    public void executar(){

    }
    public void geraPopulacaoInicial(){
        for(contador_nomes=0; contador_nomes<this.populacao; contador_nomes++){
            Individuo aux = new Individuo(this.grafo);
            aux.geraGenotipoAleatorio(this.grafo);
            aux.setAptidao(this.grafo);
            aux.setNome(contador_nomes);
            originais.add(aux);
        }
    }
    public void ordenaPopulacao(ArrayList<Individuo> p){
        Collections.sort(p, new Compara());
            
    }
    public boolean calculaMutacao(){
        Random r = new Random();
        int sorteio = r.nextInt(multipli);
        return (this.mutacao<=sorteio);
    }
    public Individuo executaMutacao(Individuo p, Grafo g){
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
