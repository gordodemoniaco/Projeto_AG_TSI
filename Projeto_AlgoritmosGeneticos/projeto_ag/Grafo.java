package projeto_ag;

import java.util.Random;

public class Grafo {
    /**
     * Classe que representa um grafo. Contém métodos de preenchimento e um setup padrão
     * Se definidos parametros do contrutor, monta-se um grafo (aleatorio ou nao), se o contrutor usado for sem parâmetros, grafo default
     */
    public final double infinito = Double.POSITIVE_INFINITY;
    int n; // numero de nós do grafo
    double [][] dist; // matriz de adjascencia
    private int inicio; // vértice inicial
    private int fim; // vertice final
    
    Grafo(int op){ // Grafo padrão pra testes
        
        double [] num1, num2, num3, num4, num5, num6, num7, num8, num9, num10;
        switch(op){
            case 1: this.n = 6;
            break;
            case 2: this.n = 8;
            break;
            case 3: this.n = 10;
            break;
        }
        double [][] grafo_aux = new double[this.n][this.n];
        if(op==1){
            num1 = new double[]{0.0,6.0,4.0,7.0,4.0,Double.valueOf(this.infinito)};
            num2 = new double[]{6.0,0.0,9.0,Double.valueOf(this.infinito),3.0,3.0};
            num3 = new double[]{4.0,9.0,0.0,7.0,8.0,Double.valueOf(this.infinito)};
            num4 = new double[]{7.0,Double.valueOf(this.infinito),7.0,0.0,5.0,5.0};
            num5 = new double[]{4.0,3.0,8.0,5.0,0.0,9.0};
            num6 = new double[]{Double.valueOf(this.infinito),3.0,Double.valueOf(this.infinito),5.0,9.0,0.0};
            for(int i=0; i<this.n; i++){
                grafo_aux[0][i] = num1[i];
                grafo_aux[1][i] = num2[i];
                grafo_aux[2][i] = num3[i];
                grafo_aux[3][i] = num4[i];
                grafo_aux[4][i] = num5[i];
                grafo_aux[5][i] = num6[i];
            }
        }
        if(op==2){
            num1 = new double[]{0,3,8,7,4,9,4,1};
            num2 = new double[]{3,0,Double.valueOf(this.infinito),7,Double.valueOf(this.infinito),10,7,2};
            num3 = new double[]{8,Double.valueOf(this.infinito),0,Double.valueOf(this.infinito),5,5,7,1};
            num4 = new double[]{7,7,Double.valueOf(this.infinito),0,2,4,3,3};
            num5 = new double[]{4,Double.valueOf(this.infinito),5,2,0,Double.valueOf(this.infinito),1,7};
            num6 = new double[]{9,10,5,4,Double.valueOf(this.infinito),0,6,1};
            num7 = new double[]{4,7,7,3,1,6,0,Double.valueOf(this.infinito)};
            num8 = new double[]{1,2,1,3,7,1,Double.valueOf(this.infinito),0};
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
        if(op==3){
            num1 = new double[]{0,3,8,7,4,9,4,1,9,1};
            num2 = new double[]{3,0,Double.valueOf(this.infinito),7,Double.valueOf(this.infinito),10,7,2,2,3};
            num3 = new double[]{8,Double.valueOf(this.infinito),0,Double.valueOf(this.infinito),5,5,7,1,5,4};
            num4 = new double[]{7,7,Double.valueOf(this.infinito),0,2,4,3,3,6,1};
            num5 = new double[]{4,Double.valueOf(this.infinito),5,2,0,Double.valueOf(this.infinito),1,7,Double.valueOf(this.infinito),2};
            num6 = new double[]{9,10,5,4,Double.valueOf(this.infinito),0,6,1,3,3};
            num7 = new double[]{4,7,7,3,1,6,0,Double.valueOf(this.infinito),2,1};
            num8 = new double[]{1,2,1,3,7,1,Double.valueOf(this.infinito),0,3,4};
            num9 = new double[]{9,2,5,6,Double.valueOf(this.infinito),3,2,3,0,Double.valueOf(this.infinito)};
            num10 = new double[]{1,3,4,1,2,3,1,4,Double.valueOf(this.infinito),0};
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
        //Scanner entrada = new Scanner (System.in);
        int aux_v=this.n-1;
        /*
        do{
            System.out.println("Defina o vértice de Início entre 0 e " + (this.n-1)+ ":");
            aux_v = entrada.nextInt();
        }while(aux_v<0 || aux_v>=this.n);
        this.inicio = aux_v;
        do{
            System.out.println("Defina o vértice de Fim entre 0 e "+ (this.n-1) +" (Diferente do Início em "+(this.inicio)+"): ");
            aux_v = entrada.nextInt();
        }while(((aux_v<0) || (aux_v>=this.n))&&(aux_v!=this.inicio));
        this.fim = aux_v;
        entrada.close();
        */
        this.inicio = 0;
        this.fim = aux_v;
        System.out.println("Início: " + (this.inicio) + "| Fim: "+ (this.fim));

    }
    public String printSelecao(boolean selecao){
        if(selecao){
            return "Roleta";
        }
        return "Torneio";
    }
    public int posicaoCorte(){
        int aux;
        int op;
        op = 2; // opcao da posição de corte (1 aleatória, 2 n/2)
        if(op==1){
            Random gerador = new Random();
            int temp;
            do{
                temp = gerador.nextInt(this.n);
            }while((temp== 0 )|| (temp == (this.n-1)));
            aux=temp;
            System.out.println("Posição de Corte Aleatória: "+aux);
        }
        if(op==2){
            aux = (this.n)/2;
            System.out.println("Posição de Corte: "+aux);
        }
        else{
            aux = (this.n)/2;
            System.out.println("Posição de Corte: "+aux);
        }
        return aux;
    }
}