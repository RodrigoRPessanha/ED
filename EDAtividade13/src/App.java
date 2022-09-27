public class App {
    public static void main(String[] args){
        int[][] M = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        int[][] N = {{1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3,3},{4,4,4,4,4,4},{5,5,5,5,5,5},{6,6,6,6,6,6}};
        for(int i = 0; i < N.length; i++) {
            for(int j = 0; j < N[1].length; j++) {
                System.out.print(N[i][j]+" ");
            }
            System.out.println("");
        }

        System.out.println(funcaoA(3, 6));
        System.out.println(funcaoB(3, 6));
        System.out.println(funcaoC(29));
        System.out.println(funcaoD(M, M.length, M[1].length));
        System.out.println(funcaoE(N, N.length, N[1].length));
    }

    public static double funcaoA(int a, int n) {
        double s = 0;                                              // 1
        for(int i = 1; i <= n; i++){                               // n+1
            s += i/(Math.pow(a, i));                               // n
        }
        return s;                                                  // 1
    }                                                              // local = 2n+3 / assintótica = O(n)



    public static int funcaoB(int n, int m) {
        int s = 0;                                                 // 1
        for(int i = 1; i <= n; i++) {                              // n+1
            for(int j = 1; j <= m; j++) {                          // n*n
                s+= i*j;                                           // n*(n-1)
            }
        }
        return s;                                                  // 1
    }                                                              // local = 2n²+3 / assintótica = O(n²)



    public static int funcaoC(int n) {
        for (int i = 2; i < n; i++) {                              // n-2
            if (n % i == 0){                                       // n-3
                return 0;                                          // 1
            }
        }
        return 1;                                                  // 1
    }                                                              // local = 2n-3 / assintótica = O(n)


    
    public static int funcaoD(int[][] A, int n, int m) {
        int s = 0, aux = 0, b = 0;                                 // 1
        for (int k = 1; k < m; k++) {                              // n
            b+=A[k][1];                                            // n-1
        }
        s = b;                                                     // 1           
        for (int j = 1; j < m; j++) {                              // n
            for (int i = 1; i < n; i++) {                          // n*(n-1)
                aux += A[i][j];                                    // (n-1)*(n-1)
            }
            if (aux < s){                                          // n-1
                s = aux;                                           // n-1
            }
        }
        return s;                                                  // 1       
    }                                                              // local = 2n²+2n+1 / assintótica = O(n²)


    
    public static int funcaoE(int[][] B, int n, int m) {
        int s = 0, aux = 1, b = 1;                                 // 1
        for (int k = 1; k < m; k++) {                              // n
            b*=B[1][k];                                            // n-1
        }
        s = b;                                                     // 1
        for (int i = 1; i < n; i++) {                              // n
            for (int j = 1; j < m; j++) {                          // n*(n-1)
                aux *= B[i][j];                                    // (n-1)*(n-1)
            }
            if (aux > s){                                          // n-1
                s = aux;                                           // n-1
            }
            aux = 1;                                               // n-1
        }
        return s;                                                  // 1
    }                                                              // local = 2n²+2n+1 / assintótica = O(n²)



    public static int funcaoF(int[][] C, int n) {
        int s = 0;                                                 // 1
        for(int i = 1; i <= n; i++) {                              // n+1
            for(int j = 1; j <= n; j++) {                          // (n+1)*n
                if(i<j){                                           // n*n
                    s+= C[i][j];                                   // n*n
                }
            }
        }
        return s;                                                  // 1
    }                                                              // local = 3n²+3n+2 / assintótica = O(n²)
}
