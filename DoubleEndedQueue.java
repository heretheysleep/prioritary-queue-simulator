public class DoubleEndedQueue extends Queue {
    public DoubleEndedQueue(int length) {
        super(length);
    }

    public boolean addClientAtHead(Client client) {
        int previousElementIndex = (nextClientIndex - 1 + length) % length;

        if (isFull()) {
            return false;
        }

        clients[previousElementIndex] = client;
        nextClientIndex = previousElementIndex;
        numberOfClients++;

        return true;
    }

    public Client removeClientAtEnd() {
        Client client = null;
        int lastElementIndex = (nextClientIndex + numberOfClients - 1) % length;

        if (isEmpty()) {
            return client;
        }
        
        client = clients[lastElementIndex];
        numberOfClients--;

        return client;
    }
}
