package projeto_ag;

import java.util.Random;


/**
 * Um indivíduo que representa um estado final do caminho percorrido.
 *
 * @author Thomas Adam da Costa
 */
public class Individuo {

    double infinito = 999999999.90;// variavel definindo infinito

    private int[] genotipo; // Vetor Decimal onde as posicoes representam a ordem e os valores (1 a n) representam os vértices (0 = nao visitado)

    private double aptidao=infinito; // Valor somado do caminho final (quanto menor, melhor)

    public int[] getGenotipo() { // método que retorna o genotipo (vetor decimal)
        return genotipo;
    }

    public double getAptidao() { // metodo que retorna a aptidao
        return this.aptidao;
    }

    public void setAptidao(Grafo g) { // metodo que atualiza a aptidao do individuo
        double aux = 0;
        for(int i=1; i<this.genotipo.length; i++){
            if(g.getDist(i-1, i)>=infinito){
                aux = infinito; // infinito constante como valor máximo
                break;
            } 
            aux += g.getDist(i-1, i);   // somatorio das arestas do caminho
        }
        this.aptidao = aux;
    }

    public void setGenotipo(int[] genotipo) { // metodo que atualiza o genótipo quando necessário
        this.genotipo = genotipo; 
    }
    Individuo (Grafo g){    // construtor de indivíduo
        this.genotipo = new int[g.n];
    }

    public void geraGenotipoAleatorio(Grafo g){
        Random r = new Random(); // gerador de numeros aleatórios
        this.genotipo[0] = g.getInicio(); // definindo o vertice de inicio

        for(int i=1; i<this.genotipo.length; i++){
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