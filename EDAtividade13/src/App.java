public class App {
    public static void main(String[] args){
        System.out.println(funcaoA(3, 6));
        System.out.println(funcaoB(3, 6));
        System.out.println(funcaoC(29));
    }

    public static double funcaoA(int a, int n) {
        double s = 0;                                        // 1

        for(int i = 1; i <= n; i++){                         // n+1
            s += i/(Math.pow(a, i));                         // n
        }
        return s;                                            // 1
    }                                                        // local = 2n+3/ assintótica = O(n)

    public static int funcaoB(int n, int m) {
        int s = 0;                                           // 1
        for(int i = 1; i <= n; i++) {                        // n+1
            for(int j = 1; j <= m; j++) {                    // n*n+1
                s+= i*j;                                     // n*n+1
            }
        }
        return s;                                            // 1
    }                                                        // local = 2n²+3n+3 / assintótica = O(n²)

    public static int funcaoC(int n) {
        for (int i = 2; i < n; i++) {                        // n
            if (n % i == 0){                                 // n
                return 0;                                    // 1
            }
        }
        return 1;                                            // 1
    }                                                        // local = n² + 2/ assintótica = O(n²)
}
