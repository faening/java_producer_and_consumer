package entities;

public class Queue {
    private int addOn;
    private int removeOn;
    private int quantityItems;
    private int queue[];

    public Queue(int queueLength) {
        this.queue = new int[queueLength];
        this.addOn = 0;
        this.removeOn = 0;
        this.quantityItems = 0;
    }

    public void insert(int element) {
        // Verificar se há espaço na fila para inserir
        if (this.quantityItems < this.queue.length) {

            // Se for o último índice da fila, deve voltar para o início
            if (this.addOn == this.queue.length - 1) {
                this.addOn = 0;
            }

            this.queue[addOn] = element;
            this.addOn++;
        }
    }

    public void remove() {
        // Verificar se a fila está vazia
        this.queue.
    }

    public boolean isFull() {
        return this.quantityItems == this.queue.length;
    }

    public boolean isEmpty() {
        return this.quantityItems == 0;
    }
}
