public class Heap{
    int[] lista = new int[9];
    int n = 0;
    
    public void inserir(int novo) {
        int M = lista.length;
        if(this.n == 0){
            this.lista[0] = novo;
            this.n++;
        }else{
            if(this.n < M){
            this.lista[this.n+1] = novo;
            this.n++;
            subir(this.n);  
            } 
        }
    }

    public void subir(int i){
        int j = i/2;
        if(j >= 0){
            if(this.lista[i] > this.lista[j]){
                troca(i, j);
                subir(j);
            }
        }
    }

    public void remover() {
        if(this.n != 0) {
            lista[0] = lista[this.n];
            this.n--;
            descer(0);
        }
    }

    public void descer(int i) {
        int j = i * 2;
        if (j<=this.n) {
            if(j<this.n){
                if(this.lista[j+1] > this.lista[j]){
                    j++;
                }
            }
            if (lista[j] > lista[i]) {
                troca(i, j);
                descer(j);
            }
        }
    }

    public void troca(int a, int b){
        int aux = this.lista[a];
        this.lista[a] = this.lista[b];
        this.lista[b] = aux; 
    }

    public void arranjar() {
        for(int i = this.n/2; i > 1; i--) {
            descer(i);
        }
    }

    public void imprimir() {    
        System.out.print("[ ");
        for(int i = 0; i < this.n; i++) {
            System.out.print(this.lista[i]+" ");
        }
        System.out.println("]");
    }
}