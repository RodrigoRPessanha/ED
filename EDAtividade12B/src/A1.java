public class A1 {
    public static void main(String[] args) throws Exception {
        Heap h = new Heap();
        int[] v = {63, 33, 94, 47, 82, 80, 53, 61};
        h.arranjar();
        for (int i = 0; i < 8; i++) {
            int n = v[i];
            h.inserir(n);
        }
        h.imprimir();
    }
}
