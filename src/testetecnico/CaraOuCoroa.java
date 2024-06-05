package testetecnico;

public class CaraOuCoroa {

public static void main(String[] args){
   // false = coroa
    boolean[] moedas = {false, false, false, false, false, false};
    

    
    // Estado inicial das moedas
    System.out.println("inicio: " + displayAtual(moedas));
    
    // rodada 1
    virar(moedas, new int[]{0, 1, 2, 3, 4});
    System.out.println("Movimento 1: " + displayAtual(moedas));
    
    // rodada 2
    virar(moedas, new int[]{ 1, 2, 3, 4, 5});
    System.out.println("Movimento 2: " + displayAtual(moedas));
    
    // rodada 3
    virar(moedas, new int[]{0, 2, 3, 4,5});
    System.out.println("Movimento 3: " + displayAtual(moedas));
    
    // rodada 4
    virar(moedas, new int[]{0, 1, 3, 4, 5});
    System.out.println("Movimento 4: " + displayAtual(moedas));
    
    // rodada 5
    virar(moedas, new int[]{0, 1, 2, 4,5});
    System.out.println("Movimento 5: " + displayAtual(moedas));
    
 // rodada 6
    virar(moedas, new int[]{0, 1, 2, 3,5});
    System.out.println("Movimento 5: " + displayAtual(moedas));
    
 
}
    
    //funçao p/ virar moedas

public static void virar(boolean[] moedas, int[] indices) {
    for (int index : indices) {
        moedas[index] = !moedas[index];
    }
}

// Função para mostrar a disposiçao atual das moedas
public static String displayAtual(boolean[] moedas) {
    StringBuilder sb = new StringBuilder();
    for (boolean moeda : moedas) {
        sb.append(moeda ? "0" : "1").append(" ");
    }
    return sb.toString().trim();
}
}
