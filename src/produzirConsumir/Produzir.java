package produzirConsumir;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Produzir implements Runnable {

    // Instantiating the Queue
    private Fila fila;
    private int escolha;

    // Constructor
    public Produzir(Fila fila, int escolha) {
        this.fila = fila;
        this.escolha = escolha;
    }

    public void run() {

        // Critical Section With Control
        if (escolha == 1) {     
           
            for (int i = 0; i < 10; i++) {
                Random random = new Random();
                int data = random.nextInt(100); // Random Number

                
                // Producer Placing the Products
                fila.putComControle(data);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        // Critical Section Without Control
        else {

            for (int j = 0; j < 10; j++) {
                Random random = new Random();
                int data2 = random.nextInt(100); // Generating Random Numbers
                fila.putSemControle(data2);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Produzir.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
