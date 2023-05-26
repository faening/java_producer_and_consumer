import entities.MyQueue;
import entities.Producer;
import entities.Consumer;

public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);

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