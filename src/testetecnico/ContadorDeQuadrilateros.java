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
		

		if (linhas < colunas) {
			System.out.println("o número de quadriláteros é: " + linhas/2);
		} else {
			System.out.println("o número de quadriláteros é: " + colunas/2);
		}
	}
}
