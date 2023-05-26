package entities;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    private Queue<Integer> queue;
    private int MAX_LENGTH;

    public MyQueue(int MAX_LENGTH) {
        this.queue = new LinkedList<>();
        this.MAX_LENGTH = MAX_LENGTH;
    }

    public synchronized int add(int number) throws InterruptedException {
        while(queue.size() == MAX_LENGTH) {
            System.out.println("Full queue, waiting to resume production");
            wait(); // Esperar se a fila está cheia
        }
        queue.add(number);
        if(queue.size() == 1) {
            notifyAll(); // Notifica os consumidores que há produto disponível
        }
        return number;
    }

    public synchronized int remove() throws InterruptedException {
        while(queue.isEmpty()) {
            System.out.println("Empty queue, waiting to resume consumption");
            wait(); // Esperar se a fila está vazia
        }
        int number = queue.remove();
        if(queue.size() == MAX_LENGTH - 1) {
            notifyAll(); // Notifica os produtores que há espaço vazio na fila
        }
        return number;
    }
}
