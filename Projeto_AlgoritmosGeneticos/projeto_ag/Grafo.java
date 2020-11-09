package projeto_ag;

import java.util.Random;

public class Grafo {
    /**
     * Classe que representa um grafo. Contém métodos de preenchimento e um setup padrão
     * Se definidos parametros do contrutor, monta-se um grafo (aleatorio ou nao), se o contrutor usado for sem parâmetros, grafo default
     */
    public final int infinito = 100000;
    int n; // numero de nós do grafo
    int [][] dist; // matriz de adjascencia
    private int inicio; // vértice inicial
    private int fim; // vertice final

    Grafo(int vertices){ // Grafo padrão pra testes
        
        int [] num1, num2, num3, num4, num5, num6, num7, num8, num9, num10;
        this.n = vertices;
        int [][] grafo_aux = new int[this.n][this.n];
        if(vertices==6){
            num1 = new int[]{0,6,4,7,4,infinito};
            num2 = new int[]{6,0,9,infinito,3,3};
            num3 = new int[]{4,9,0,7,8,infinito};
            num4 = new int[]{7,infinito,7,0,5,5};
            num5 = new int[]{4,3,8,5,0,9};
            num6 = new int[]{infinito,3,infinito,5,9,0};
            for(int i=0; i<this.n; i++){
                grafo_aux[0][i] = num1[i];
                grafo_aux[1][i] = num2[i];
                grafo_aux[2][i] = num3[i];
                grafo_aux[3][i] = num4[i];
                grafo_aux[4][i] = num5[i];
                grafo_aux[5][i] = num6[i];
            }
        }
        else if(vertices==8){
            num1 = new int[]{0,3,8,7,4,9,4,1};
            num2 = new int[]{3,0,infinito,7,infinito,10,7,2};
            num3 = new int[]{8,infinito,0,infinito,5,5,7,1};
            num4 = new int[]{7,7,infinito,0,2,4,3,3};
            num5 = new int[]{4,infinito,5,2,0,infinito,1,7};
            num6 = new int[]{9,10,5,4,infinito,0,6,1};
            num7 = new int[]{4,7,7,3,1,6,0,infinito};
            num8 = new int[]{1,2,1,3,7,1,infinito,0};
            for(int i=0; i<this.n; i++){
                grafo_aux[0][i] = num1[i];
                grafo_aux[1][i] = num2[i];
                grafo_aux[2][i] = num3[i];
                grafo_aux[3][i] = num4[i];
                grafo_aux[4][i] = num5[i];
                grafo_aux[5][i] = num6[i];
                grafo_aux[6][i] = num7[i];
                grafo_aux[7][i] = num8[i]; 
            }
        }
        else if(vertices==10){
            num1 = new int[]{0,3,8,7,4,9,4,1,9,1};
            num2 = new int[]{3,0,infinito,7,infinito,10,7,2,2,3};
            num3 = new int[]{8,infinito,0,infinito,5,5,7,1,5,4};
            num4 = new int[]{7,7,infinito,0,2,4,3,3,6,1};
            num5 = new int[]{4,infinito,5,2,0,infinito,1,7,infinito,2};
            num6 = new int[]{9,10,5,4,infinito,0,6,1,3,3};
            num7 = new int[]{4,7,7,3,1,6,0,infinito,2,1};
            num8 = new int[]{1,2,1,3,7,1,infinito,0,3,4};
            num9 = new int[]{9,2,5,6,infinito,3,2,3,0,infinito};
            num10 = new int[]{1,3,4,1,2,3,1,4,infinito,0};
            for(int i=0; i<this.n; i++){
                grafo_aux[0][i] = num1[i];
                grafo_aux[1][i] = num2[i];
                grafo_aux[2][i] = num3[i];
                grafo_aux[3][i] = num4[i];
                grafo_aux[4][i] = num5[i];
                grafo_aux[5][i] = num6[i];
                grafo_aux[6][i] = num7[i];
                grafo_aux[7][i] = num8[i];
                grafo_aux[8][i] = num9[i];
                grafo_aux[9][i] = num10[i];
            }
            
        }
        this.dist = grafo_aux;
    }
    public void imprimegrafo(){
        for(int i=0; i<=this.n; i++){
            System.out.print(i+"     ");
        }
        System.out.println("");
        for(int i=0; i<this.n; i++){
            System.out.print((i+1)+"     ");
            for(int j=0; j<this.n; j++){
                int aux = this.getDist(i, j);
                System.out.printf("%.2f ", aux);
            }
            System.out.println("");
        }
    }
    public int getDist(int v1, int v2){
        return this.dist[v1][v2];
    }
    public void setInicioFim(int inicio, int fim){
        this.inicio = inicio;
        this.fim = fim;
    }
    public int getInicio(){
        return this.inicio;
    }
    public int getFim(){
        return this.fim;
    }
    public String printSelecao(boolean selecao){
        if(selecao){
            return "Roleta";
        }
        return "Torneio";
    }
    public int posicaoCorte(boolean op){
        int aux;
        if(op){
            Random gerador = new Random();
            int temp;
            do{
                temp = gerador.nextInt(this.n);
            }while((temp== 0 )|| (temp == (this.n-1)));
            aux=temp;
        }
        else{
            aux = (this.n)/2;
        }
        return aux;
    }
}