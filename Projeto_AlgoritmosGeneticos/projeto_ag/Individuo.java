package projeto_ag;

import java.util.Random;

/**
 * Um indivíduo que representa um estado final do caminho percorrido.
 *
 * @author Thomas Adam da Costa
 */
public class Individuo{

    private Grafo g;
    private int nome;

    private int[] genotipo; // Vetor Decimal onde as posicoes representam a ordem e os valores (1 a n)
                            // representam os vértices (0 = nao visitado)

    private int aptidao; // Valor somado do caminho final (quanto menor, melhor)

    public int[] getGenotipo() { // método que retorna o genotipo (vetor decimal)
        return genotipo;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public int getAptidao() { // metodo que retorna a aptidao
        return this.aptidao;
    }

    public void setAptidao(Grafo g, Individuo p) { // metodo que atualiza a aptidao do individuo
        int aux = 0;
        int i=0;
        if(p.genotipo[0]!=g.getInicio())
            aux = aux + 100000;
        for(i=1; i<(g.n); i++){
            aux = aux + g.getDist(p.genotipo[i-1], p.genotipo[i]);
        }
        if(p.genotipo[i-1]!=g.getFim())
            aux = aux + 100000;
        this.aptidao = aux;
    }
    public void setGenotipo(int[] genotipo) { // metodo que atualiza o genótipo quando necessário
        this.genotipo = genotipo; 
    }
    Individuo (Grafo g){    // construtor de indivíduo
        this.genotipo = new int[g.n];
        this.g = g;
        this.startGenotipo(g);
    }
    Individuo (Grafo g, Individuo pai, Individuo mae, int corte, int nome){
        this.genotipo = new int[g.n];
        this.g = g;
        setNome(nome);
        int i;
        for(i=0; i<corte; i++)
            this.genotipo[i] = pai.genotipo[i];
        for(i=corte; i<this.g.n; i++)
            this.genotipo[i] = mae.genotipo[i];
        this.setAptidao(this.g, this);
    }
    public void geraGenotipoAleatorio(Grafo g, Individuo p){
        Random r = new Random(); // gerador de numeros aleatórios
        int aleatorio;
        this.startGenotipo(g);
        for(int i=1; i<(g.n); i++){
            aleatorio = r.nextInt(g.n);
            p.genotipo[i] = aleatorio;
        }
        p.setAptidao(g, p);
    }
    public void startGenotipo(Grafo g){
        this.genotipo = new int[g.n];
        this.genotipo[0] = g.getInicio();
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
