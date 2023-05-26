import entities.Consumer;
import entities.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque(10);

        Thread threadProducer1 = new Thread( new Producer(queue) );
        Thread threadConsumer1 = new Thread( new Consumer(queue) );

        threadProducer1.start();
        threadConsumer1.start();

        try {
            threadProducer1.join();
            threadConsumer1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}