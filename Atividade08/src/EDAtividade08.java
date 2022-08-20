import java.util.Scanner;

public class EDAtividade08 {

	public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Qual a altura da árvore desejada?");
        int h = teclado.nextInt();
		System.out.print("Resultado: "+nosNecessariosArvoreAVL(h));
	}
	
	static long nosNecessariosArvoreAVL(int h) {
		if(h == 0) {
			return 0;
		}else if (h == 1) {
			return 1;
		}
		else {
			return 1 + nosNecessariosArvoreAVL(h-1) + nosNecessariosArvoreAVL(h-2);
		} 	
	}	
}