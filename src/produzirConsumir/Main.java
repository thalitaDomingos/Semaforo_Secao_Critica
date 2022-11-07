package produzirConsumir;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Uso de uma Seção Crítica com Controle");
        System.out.println("2 - Uso de uma Seção Crítica sem Controle"); 

        Scanner teclado = new Scanner(System.in);
        int escolha = teclado.nextInt();    
        

        Fila fila = new Fila();  // creating the buffer queue

        Produzir produzir = new Produzir(fila, escolha);
        Consumir consumir = new Consumir(fila, escolha);
    
        Thread produzirThread = new Thread(produzir);
        Thread consumirThread = new Thread(consumir);
        
        produzirThread.start();   // start in producer thread with Critical Section
        consumirThread.start(); // start in consumer thread with Critical Section   
    }
}
