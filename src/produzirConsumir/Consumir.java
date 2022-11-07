package produzirConsumir;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumir implements Runnable {

    private Fila fila;
    private int escolha;

    // Constructor
    public Consumir(Fila fila, int escolha) {
        this.fila = fila;
        this.escolha = escolha;
    }

    public void run() {

        // Critical Section With Control
        if (escolha == 1) {

            for (int i = 0; i < 10; i++) {

                // Consuming the items
                fila.getComControle();

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

                fila.getSemControle();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumir.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
