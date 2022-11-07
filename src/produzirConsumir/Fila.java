package produzirConsumir;

import java.util.concurrent.Semaphore;

public class Fila {

    private int item;
    private Semaphore semaforoConsumir = new Semaphore(0);  // Initializing with 0 so that put() executes first (producer)
    private Semaphore semaforoProduzir = new Semaphore(1);


    // Critical Section With Control - Function to get an item from the buffer
    public void getComControle() 
    {
        try {  
            semaforoConsumir.acquire();  // Before the consumer picks up an item, need to get a permission from semaforoConsumir

        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        System.out.println("Consumiu o item número " + item + " da receita"); 
        semaforoProduzir.release(); // After consuming an item, notify the producer
    }
  
    // Putting item in the buffer
    public void putComControle(int item) 
    {
        try {
            semaforoProduzir.acquire(); // need permission from semaphoreProducer to produce item

        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        this.item = item; 
        System.out.println(" ");
        System.out.println("Produziu o item número " + item + " da receita");

        semaforoConsumir.release(); // Notifies the consumer
    }


    // Critical Section Without Control 
    public void getSemControle() 
    {
        System.out.println("Consumiu o item número " + item + " da receita");
    }

    // Produces the item and puts it in the buffer
    public void putSemControle(int item) {
        this.item = item;
        System.out.println("Produziu o item número " + item + " da receita");
    }
}
