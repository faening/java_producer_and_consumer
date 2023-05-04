package entities;

import java.util.LinkedList;

public class Store {
    private final int MAX_QUEUE_LENGTH;
    private LinkedList<Integer> store = new LinkedList<>();;
    private final Object semaphoreProducer = new Object();
    private final Object semaphoreConsumer = new Object();

    public Store(int MAX_QUEUE_LENGTH) {
        this.MAX_QUEUE_LENGTH = MAX_QUEUE_LENGTH;
    }

    public void insert(int n) {
        this.store.add(n);
        synchronized (semaphoreConsumer) {
            semaphoreConsumer.notifyAll();
        }
    }

    public void remove() {
        this.store.poll();
        synchronized (semaphoreProducer) {
            semaphoreProducer.notifyAll();
        }
    }

    public boolean isFull() {
        return this.MAX_QUEUE_LENGTH == this.store.size();
    }

    public boolean isEmpty() {
        return this.store.isEmpty();
    }

    public void producerSleep() {
        synchronized (semaphoreConsumer) {
            try {
                semaphoreConsumer.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void consumerSleep() {
        synchronized (semaphoreConsumer) {
            try {
                semaphoreConsumer.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
