package testetecnico;

import java.util.Scanner;

public class ContadorDeQuadrilateros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pergunta as dimensões do array
        System.out.print("Digite o número de linhas: ");
        int linhas = scanner.nextInt();
        System.out.print("Digite o número de colunas: ");
        int colunas = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Inicializa o array
        char[][] array = new char[linhas][colunas];
        System.out.println("Digite as linhas do array:");
        for (int i = 0; i < linhas; i++) {
            array[i] = scanner.nextLine().toCharArray();
        }

        // Conta e imprime o número de quadriláteros
        int numeroDeQuadrilateros = contarQuadrilateros(array);
        System.out.println("Número de quadriláteros: " + numeroDeQuadrilateros);
    }

    public static int contarQuadrilateros(char[][] array) {
        int linhas = array.length;
        int colunas = array[0].length;
        int quadrilaterosCount = 0;

        boolean[][] visitado = new boolean[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (!visitado[i][j]) {
                    char caracter = array[i][j];
                    int m = i;
                    int n = j;
                    while (m < linhas && array[m][j] == caracter) {
                        m++;
                    }
                    while (n < colunas && array[i][n] == caracter) {
                        n++;
                    }
                    if (verificarQuadrilatero(array, i, j, m - 1, n - 1, caracter)) {
                        marcarVisitados(visitado, i, j, m - 1, n - 1);
                        quadrilaterosCount++;
                    }
                }
            }
        }

        return quadrilaterosCount;
    }

    public static boolean verificarQuadrilatero(char[][] array, int i1, int j1, int i2, int j2, char caracter) {
        // Verifica as bordas horizontais
        for (int j = j1; j <= j2; j++) {
            if (array[i1][j] != caracter || array[i2][j] != caracter) {
                return false;
            }
        }

        // Verifica as bordas verticais
        for (int i = i1; i <= i2; i++) {
            if (array[i][j1] != caracter || array[i][j2] != caracter) {
                return false;
            }
        }

        return true;
    }

    public static void marcarVisitados(boolean[][] visitado, int i1, int j1, int i2, int j2) {
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                visitado[i][j] = true;
            }
        }
    }
}
