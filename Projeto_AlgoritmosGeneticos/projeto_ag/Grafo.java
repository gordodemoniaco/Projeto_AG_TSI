package projeto_ag;

import java.util.Scanner;

public class Grafo {
    /**
     * Classe que representa um grafo. Contém métodos de preenchimento e um setup padrão
     * Se definidos parametros do contrutor, monta-se um grafo (aleatorio ou nao), se o contrutor usado for sem parâmetros, grafo default
     */
    public final double infinito = 999999999.99;
    int n; // numero de nós do grafo
    double [][] dist; // matriz de adjascencia
    private int inicio; // vértice inicial
    private int fim; // vertice final

    Grafo(int tamanho, boolean aleatorio){ //Grafo mutável (aleatorio = true, montável = false, tamanho = numero de vértices)
        this.n = tamanho;
        this.dist = new double[this.n][this.n];
        
        if(!aleatorio){ // Se a opçao for não aleatório
            System.out.println("Distância entre os Vértices. Se não houver arestas entre os vertices, a distancia digitada deverá ser 0 (será substituida por infinito).");
            Scanner entrada = new Scanner (System.in);
            for(int i=0; i<this.n; i++){
                for(int j=i; j<this.n; j++){
                    if(i==j){
                        double num = 0.0; // Distancia pra vertice no mesmo ponto, ou seja, 0
                        this.dist[i][j] = num;
                    }
                    else{
                        System.out.println("Distância entre "+ i + " e "+ j +": ");
                        double num = entrada.nextDouble();
                        if (num == 0.0){
                            num = this.infinito; // se a distancia for deixada como zero pelo usuário, será considerada sem aresta (explicado)
                        }
                        this.dist[i][j] = num;
                        this.dist[j][i] = num;
                    }
                }
            }
            entrada.close();
        }
        else {
            for(int i=0; i<this.n; i++){
                for(int j=0; j<this.n; j++){
                    if(i!=j){
                        double num = Math.round(Math.random()*10.0);
                        if (num == 0.0){
                            num = this.infinito;
                        }
                        this.dist[i][j] = num;
                    }
                    else if(i==j){
                        double num = 0.0;
                        this.dist[i][j] = num;
                    }
                    
                }
            }

        }
        
    }
    Grafo(){ // Grafo padrão pra testes
        this.n = 6;
        double [][] grafo_aux = new double[this.n][this.n];
        double [] num1 = {0.0,6.0,4.0,7.0,4.0,Double.valueOf(this.infinito)};
        double [] num2 = {6.0,0.0,9.0,Double.valueOf(this.infinito),3.0,3.0};
        double [] num3 = {4.0,9.0,0.0,7.0,8.0,Double.valueOf(this.infinito)};
        double [] num4 = {7.0,Double.valueOf(this.infinito),7.0,0.0,5.0,5.0};
        double [] num5 = {4.0,3.0,8.0,5.0,0.0,9.0};
        double [] num6 = {Double.valueOf(this.infinito),3.0,Double.valueOf(this.infinito),5.0,9.0,0.0};
        
        for(int i=0; i<this.n; i++){
            grafo_aux[0][i] = num1[i];
            grafo_aux[1][i] = num2[i];
            grafo_aux[2][i] = num3[i];
            grafo_aux[3][i] = num4[i];
            grafo_aux[4][i] = num5[i];
            grafo_aux[5][i] = num6[i];
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
                double aux = this.getDist(i, j);
                System.out.printf("%.2f ", aux);
            }
            System.out.println("");
        }
    }
    public double getDist(int v1, int v2){
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
    public void definepontas(){
        Scanner entrada = new Scanner (System.in);
        System.out.printf("Defina o vértice de Início entre 1 e %d: ", this.n);
        this.inicio = entrada.nextInt();
        System.out.printf("Defina o vértice de Início entre 1 e %d (Diferente de %d): ", this.n, this.inicio);
        this.fim = entrada.nextInt();
        entrada.close();
        System.out.println("Início: " + this.inicio + "| Fim: "+ this.fim);

    }
}