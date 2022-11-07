public class Queue {
    protected int length;
    protected Client[] clients;
    protected int numberOfClient;
    protected int nextClientIndex;

    public Queue(int length) {
        this.length = length;
        clients = new Client[length];
        numberOfClient = 0;
        nextClientIndex = 0;
    }

    public boolean isEmpty() {
        return numberOfClient == 0;
    }

    public boolean isFull() {
        return numberOfClient == length;
    }

    public boolean addElement(Client element) {
        int endOfQueue = (numberOfClient + nextClientIndex) % length;

        if (isFull()) {
            return false;
        }

        clients[endOfQueue] = element;
        numberOfClient++;

        return true;
    }

    public Client removeElement() {
        Client element = null;

        if (isEmpty()) {
            return element;
        }

        element = clients[nextClientIndex];

        nextClientIndex = (nextClientIndex + 1) % length;
        numberOfClient--;

        return element;
    }
}
