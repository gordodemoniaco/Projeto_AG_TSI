package projeto_ag;

import java.util.Comparator;
import java.util.Random;

/**
 * Um indivíduo que representa um estado final do caminho percorrido.
 *
 * @author Thomas Adam da Costa
 */
public class Individuo {

    private double infinito = Double.POSITIVE_INFINITY;// variavel definindo infinito
    private static double aptidaoMax = 99999.99;
    private Grafo g;
    private int nome;

    private int[] genotipo; // Vetor Decimal onde as posicoes representam a ordem e os valores (1 a n)
                            // representam os vértices (0 = nao visitado)

    private double aptidao; // Valor somado do caminho final (quanto menor, melhor)

    public int[] getGenotipo() { // método que retorna o genotipo (vetor decimal)
        return genotipo;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public double getAptidao() { // metodo que retorna a aptidao
        this.setAptidao(this.g);
        return this.aptidao;
    }

    public void setAptidao(Grafo g) { // metodo que atualiza a aptidao do individuo
        double aux = 0;
        for(int i=1; i<this.genotipo.length; i++){
            if((this.g.getDist((i-1), i))>=(infinito-1)){
                aux = aptidaoMax; // infinito constante como valor máximo
                break;
            } 
            aux += this.g.getDist(i-1, i);   // somatorio das arestas do caminho
        }
        this.aptidao = aux;
    }
    public void setGenotipo(int[] genotipo) { // metodo que atualiza o genótipo quando necessário
        this.genotipo = genotipo; 
    }
    Individuo (Grafo g){    // construtor de indivíduo
        this.genotipo = new int[g.n];
        this.g = g;
    }
    Individuo (Grafo g, Individuo pai, Individuo mae, int corte, int nome){
        this.genotipo = new int[pai.genotipo.length];
        this.g = g;
        setNome(nome);
        int i;
        for(i=0; i<corte; i++)
            this.genotipo[i] = pai.genotipo[i];
        for(i=corte; i<pai.genotipo.length; i++)
            this.genotipo[i] = mae.genotipo[i];
        this.setAptidao(g);
    }
    public void geraGenotipoAleatorio(Grafo g){
        Random r = new Random(); // gerador de numeros aleatórios
        this.genotipo[0] = g.getInicio(); // definindo o vertice de inicio
        startGenotipo(g);
        setAptidao(g);
        for(int i=1; i<this.tamanhoIndividuo(g); i++){
            int aux;
            int anterior = this.genotipo[i-1]; // condicao de nao repeticao seguida de vertices iguais
            do{ // verificando o valor do vertice
                aux = r.nextInt(this.genotipo.length+1);
            }while((aux == g.getInicio()) || (aux == anterior));
            this.genotipo[i] = aux;
            if(aux == g.getFim()){ // se chegar ao vertice final, parar
                break;
            }
            if(i==this.genotipo.length-1){ // garantindo que o ultimo laco chegue no final
                if(this.genotipo[this.genotipo.length-1] != g.getFim())
                    this.genotipo[this.genotipo.length-1] = g.getFim();
            }
        }
    }
    public void startGenotipo(Grafo g){
        for(int i=1; i<this.genotipo.length; i++){
            this.genotipo[i] = g.getFim();
        }
    }
    public int tamanhoIndividuo(Grafo g){
        int aux=0;
        for(int i=0; i<this.genotipo.length; i++){
            aux++;
            if(this.genotipo[i]==g.getFim())
                break;
            
        }
        return aux;
    }
    public void printaIndividuo(){
        System.out.println("Nome: "+getNome()+" | Aptidão: "+getAptidao());
    }
    
}
class Compara implements Comparator<Individuo>{

    @Override
    public int compare(Individuo o1, Individuo o2) {
        if(o1.getAptidao()<o2.getAptidao())
            return 1;
        if(o1.getAptidao()>o2.getAptidao())
            return -1;
        return 0;
    }
    
}