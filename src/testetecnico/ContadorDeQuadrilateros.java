package testetecnico;

import java.util.Scanner;

public class ContadorDeQuadrilateros {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Pergunta as dimensões da matriz
		System.out.print("Digite o número de linhas: ");
		int linhas = scanner.nextInt();
		System.out.print("Digite o número de colunas: ");
		int colunas = scanner.nextInt();
		

		if (linhas <= colunas && linhas % 2 == 0) {
			System.out.println("o número de quadriláteros é: " + linhas/2);
		} else if (linhas < colunas && linhas%2==1){
			System.out.println("o número de quadriláteros é: " + ((colunas/2) + 1));
		} else if (colunas < linhas && colunas%2==0) {
			System.out.println("o número de quadriláteros é: " + colunas/2);
		}else {
			System.out.println("o número de quadriláteros é: " + ((colunas/2) + 1));
		}
		
	}
}
