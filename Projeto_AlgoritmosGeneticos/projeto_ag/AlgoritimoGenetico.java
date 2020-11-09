package projeto_ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AlgoritimoGenetico {
    private int populacao;  // tamanho da populacao
    private int geracoes;   // numero de gerações
    private int mutacao; // taxa de mutação (0.0 pra 0% e 1.0 pra 100%)
    private int elitismo;   // quantudade de individuos eleitos por elitismo
    private boolean selecao; // true = roleta | false = torneio
    private Grafo grafo;    // Grafo que será passado por parâmetro
    private ArrayList<Individuo> originais = new ArrayList<>();
    private int contador_nomes;
    private int contador_geracao=0;
    private static int multipli = 10000;
    private int combatentes;

    AlgoritimoGenetico(int populacao, int geracoes, double mutacao, int elitismo, boolean selecao, int combatentes, Grafo grafo){
        this.populacao = populacao;
        this.geracoes = geracoes;
        this.elitismo = elitismo;
        this.grafo = grafo;
        this.mutacao = (int) mutacao*multipli;
        this.selecao = selecao;
        this.combatentes = combatentes;
        this.contador_nomes = 1;
        this.contador_geracao = 0;

    }
    public void executar(){
        geraPopulacaoInicial();
        for(int i=1; i<=geracoes; i++){
            geraNovaPopulacao();
        }
    }
    public void geraNovaPopulacao(){
        contador_geracao++;
        ArrayList<Individuo> nova = new ArrayList<>();
        ordenaPopulacao(originais);
        //elitismo
        for(int i=0; i<elitismo; i++){
            nova.add(originais.get(i));
        }
        do{
            Individuo pai;
            Individuo mae;

            //Torneio ou Roleta
            if (selecao) {
                pai = roleta();
                mae = roleta();
            } else {
                pai = torneio(combatentes);
                mae = torneio(combatentes);
            }
            //corteCrossover
            Random r  = new Random();
            int corte = grafo.posicaoCorte(r.nextBoolean());
            Individuo filho1 = new Individuo(grafo, pai, mae, corte, ++contador_nomes);
            boolean teste = calculaMutacao();
            if(teste)
                executaMutacao(filho1, grafo);
            nova.add(filho1);
            Individuo filho2 = new Individuo(grafo, pai, mae, corte, ++contador_nomes);
            teste = calculaMutacao();
            if(teste)
                executaMutacao(filho2, grafo);
            nova.add(filho2);


        }while (nova.size()<originais.size());
        originais = nova;
        
    }
    public Individuo torneio(int qtd){
        Random r = new Random();
        int aux[] = new int[qtd];
        int ganhador=r.nextInt(originais.size());
        for(int i=1; i<qtd; i++){
            aux[i] = r.nextInt(originais.size());
            if(originais.get(aux[i]).getAptidao()>=originais.get(ganhador).getAptidao())
                ganhador = aux[i];

        }
        return originais.get(ganhador);
    }
    public Individuo roleta(){
        Random r = new Random();
        int tamanho = originais.size()-elitismo;
        int ganhador = r.nextInt(tamanho);
        return originais.get(ganhador);
    }
    public void geraPopulacaoInicial(){
        for(contador_nomes=0; contador_nomes<this.populacao; contador_nomes++){
            Individuo aux = new Individuo(this.grafo);
            aux.geraGenotipoAleatorio(this.grafo);
            aux.setNome(contador_nomes);
            aux.setAptidao(this.grafo);
            originais.add(aux);
        }
        ordenaPopulacao(originais);

    }
    public void printaResultado(ArrayList<Individuo> p){
        System.out.println("Geração "+contador_geracao);
        System.out.println("Indivíduo Mais apto: ");
        p.get(0).printaIndividuo();
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
