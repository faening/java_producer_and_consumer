package entities;

public class Consumer implements Runnable {
    private MyQueue queue;

    public Consumer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int number;

        while(true) {
            try {
                number = queue.remove();
                Thread.sleep(1000); // Simula o tempo de consumo
                System.out.printf("Consumer removed item %d from the queue \n", number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
