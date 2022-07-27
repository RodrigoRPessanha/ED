import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;

public class EDEncontro02 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in); 
        int menu;
        do {
            System.out.println("1- Q2 a) Lista de Adjacencia\n2- Q2 b) Matriz A de adjacencia\n3- Q2 c) Matriz B de incidencia\n4- Q3 Verificar existencia de laços\n5- Q4 Imprimir graus de cada vértice");
            menu = teclado.nextInt();
            switch (menu) {
                case 1:
                    imprimirListaAdjacencia(fazerListaDeAdjacencia());
                    break;
                case 2:
                    imprimirMatrizAdjacencia(fazerMatrizDeAdjacencia());
                    break;
                case 3:
                    imprimirMatrizIncidencia(fazerMatrizDeIncidencia());
                    break;
                case 4:
                    boolean r = verficarExistenciaDeLaços(fazerMatrizDeAdjacencia());
                    if (r) {
                        System.out.println("Existe laços");
                    }else{
                        System.out.println("Não existe laços");
                    }
                    System.out.println("");
                    break;
                case 5:
                    imprimirGrausDosVertices(fazerMatrizDeIncidencia());
                    break;
            }
            
        }while (menu!=0);

        try {
            teclado.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static LinkedList<Integer>[] fazerListaDeAdjacencia(){
        System.out.println("");
        Scanner teclado = new Scanner(System.in);
        try {
            teclado = new Scanner(new File("D:\\IFF\\19- Estrutura de Dados\\AtividadesED\\Encontro02\\Grafo.txt"));  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String[] verticesArestas = teclado.nextLine().split(" ");
        int n = Integer.parseInt(verticesArestas[0])+1;
        int m = Integer.parseInt(verticesArestas[1]);

        LinkedList<Integer>[] listaDeAdjacencia = criarListaDeAdjacenciaBase(n);

        while(teclado.hasNextLine()){
            String[] ligacao = teclado.nextLine().split(" ");
            
            int l0 = Integer.parseInt(ligacao[0]);
            int l1 = Integer.parseInt(ligacao[1]);
            listaDeAdjacencia[l0].add(l1);
            listaDeAdjacencia[l1].add(l0);
        }
        try {
            teclado.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaDeAdjacencia;
    }

    public static int[][] fazerMatrizDeAdjacencia(){
        System.out.println("");
        Scanner teclado = new Scanner(System.in);
        try {
            teclado = new Scanner(new File("D:\\IFF\\19- Estrutura de Dados\\AtividadesED\\Encontro02\\Grafo.txt"));  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String[] verticesArestas = teclado.nextLine().split(" ");
        int n = Integer.parseInt(verticesArestas[0])+1;
        int m = Integer.parseInt(verticesArestas[1]);

        int A[][] = criarMatrizAdjacenciaBase(n);

        while(teclado.hasNextLine()){
            String[] ligacao = teclado.nextLine().split(" ");
            
            int l0 = Integer.parseInt(ligacao[0]);
            int l1 = Integer.parseInt(ligacao[1]);

            A[l0][l1] = 1;
            A[l1][l0] = 1;
        }
        try {
            teclado.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return A;
    }

    public static int[][] fazerMatrizDeIncidencia(){
        System.out.println("");
        Scanner teclado = new Scanner(System.in);
        try {
            teclado = new Scanner(new File("D:\\IFF\\19- Estrutura de Dados\\AtividadesED\\Encontro02\\Grafo.txt"));  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String[] verticesArestas = teclado.nextLine().split(" ");
        int n = Integer.parseInt(verticesArestas[0])+1;
        int m = Integer.parseInt(verticesArestas[1])+1;

        int B[][] = criarMatrizIncidenciaBase(n, m);
        int a =1;
        while(teclado.hasNextLine()){
            String[] ligacao = teclado.nextLine().split(" ");   
            int l0 = Integer.parseInt(ligacao[0]);
            int l1 = Integer.parseInt(ligacao[1]);
            B[l0][a] = 1;
            B[l1][a] = 1;
            a++;
        }
        try {
            teclado.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return B;
    }

    public static void imprimirListaAdjacencia(LinkedList<Integer>[] listaDeAdjacencia) {
        int n = listaDeAdjacencia.length;
        for(int i=1; i<n; i++){
            System.out.print("Vertice: " + i + " = ");
            for(int j=0; j<listaDeAdjacencia[i].size(); j++){
                System.out.print(listaDeAdjacencia[i].get(j)+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void imprimirMatrizAdjacencia(int[][] A) {
        System.out.println("   1 2 3 4 5");
        System.out.println("");
        for (int i = 1; i < A.length; i++){
            System.out.print(i+"  ");
            for (int j = 1; j < A[i].length; j++){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");
    }

    public static void imprimirMatrizIncidencia(int[][] B) {
        System.out.println("");
        for (int i = 1; i < B.length; i++){
            for (int j = 1; j < B[i].length; j++){
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");
    }

    public static boolean verficarExistenciaDeLaços(int[][] A) {
        for (int i = 1; i < A.length; i++){
            if(A[i][i] == 1){
                return true;
            }
        }
        return false;
    }

    public static void imprimirGrausDosVertices(int[][] B) {
        int[] d = new int[B.length];
        for (int i = 1; i < B.length; i++){
            for (int j = 1; j < B[0].length; j++){
                if(B[i][j] == 1){
                    d[i]++;
                }
            }
        }
        for (int i=1; i< d.length; i++){
            System.out.println("d("+i+") = "+d[i]);
        }
        System.out.println("");
    }
    
    public static LinkedList<Integer>[] criarListaDeAdjacenciaBase(int n) {
        LinkedList<Integer>[] listaDeAdjacencia = new LinkedList[n];
        for (int contador = 1; contador < n; contador++){
            listaDeAdjacencia[contador] = new LinkedList<Integer>();
        }
        return listaDeAdjacencia;
    }

    public static int[][] criarMatrizAdjacenciaBase(int n) {
        int A[][] = new int[n][n];
        return A;
    }

    public static int[][] criarMatrizIncidenciaBase(int n, int m) {
        int B[][] = new int[n][m];
        return B;
    }
}