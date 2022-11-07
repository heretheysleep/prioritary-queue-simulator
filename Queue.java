public abstract class Queue {
    protected int length;
    protected Client[] clients;
    protected int numberOfClients;
    protected int nextClientIndex;

    public Queue(int length) {
        this.length = length;
        clients = new Client[length];
        numberOfClients = 0;
        nextClientIndex = 0;
    }

    public boolean isEmpty() {
        return numberOfClients == 0;
    }

    public boolean isFull() {
        return numberOfClients == length;
    }

    public boolean addClient(Client element) {
        int endOfQueue = (numberOfClients + nextClientIndex) % length;

        if (isFull()) {
            return false;
        }

        clients[endOfQueue] = element;
        numberOfClients++;

        return true;
    }

    public Client removeClient() {
        Client element = null;

        if (isEmpty()) {
            return element;
        }

        element = clients[nextClientIndex];

        nextClientIndex = (nextClientIndex + 1) % length;
        numberOfClients--;

        return element;
    }
}
