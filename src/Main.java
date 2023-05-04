import entities.Consumer;
import entities.Producer;
import entities.Store;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Store store = new Store(10);
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        List<Thread> producerThreads = new ArrayList<>();
        List<Thread> consumerThreads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            producerThreads.add(new Thread(producer));
            consumerThreads.add(new Thread((consumer)));
        }

        producerThreads.forEach(t -> t.start());
        consumerThreads.forEach(t -> t.start());
    }
}