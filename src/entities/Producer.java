package entities;

import java.util.Random;

public class Producer implements Runnable {
    private Store store;
    Random random = new Random();

    public Producer(Store store) {
        this.store = store;
    }
    @Override
    public void run() {
        while(true) {
            if (!store.isFull()) {
                System.out.println("Producer: Adding items to queue");
                store.insert(random.nextInt(100));
            } else {
                System.out.println("Producer: Sleeping");
                store.producerSleep();
            }
        }
    }
}
