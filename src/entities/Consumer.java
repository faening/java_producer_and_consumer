package entities;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int number;

        while(true) {
            try {
                number = queue.take();
                Thread.sleep(1000); // Simula o tempo de consumo
                System.out.printf("Consumer removed item %d from the queue \n", number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
