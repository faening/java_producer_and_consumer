package entities;

public class Producer implements Runnable {
    private MyQueue queue;

    public Producer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
            try {
                queue.add(i);
                Thread.sleep(500); // Simula o tempo de produção
                System.out.printf("Producer added item %d to the queue \n", i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
