package entities;

import java.util.Random;

public class Consumer implements Runnable {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true) {
            if (!store.isEmpty()) {
                System.out.println("Consumer: 13º dropped, let's spend");
                store.remove();
            } else {
                System.out.println("Consumer: Without money, go to sleep");
                store.consumerSleep();
            }
        }
    }
}
