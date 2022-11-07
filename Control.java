import java.util.Scanner;

public class Control {
    private Scanner scanner;
    private Queue prioritaryQueue;
    private Queue mainQueue;

    public Control() {
        scanner = new Scanner(System.in);
        prioritaryQueue = new Queue(100);
        mainQueue = new Queue(100);
    }

    public void run() {
        System.out.println("Client Queue Manager");

        while (showOptions() != 4);

        System.out.println("\n\nSee you soon.");
    }

    private int showOptions() {
        int option = 0;

        System.out.println("\n\nChoice an option:\n(1) Add client to queue\n(2) Remove client\n" +
            "(3) Remove all clients\n(4) Stop program\n\nOption:");

        while (true) {
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
                System.out.println("Error: invalid input\n\nTry again:");

                continue;
            }

            switch (option) {
                case 1:
                    readClientData();
                    break;
                case 2:
                    nextClient();
                    break;
                case 3:
                    cleanQueueClients();
                    break;
                case 4:
                    break;

                default:
                    System.out.println("Error: option invalid\n\nTry again:");
                    continue;
            }

            break;
        }

        return option;
    }

    public void readClientData() {
        String name = null;
        boolean isPrioritary = false;
        Client client = null;
        
        if (prioritaryQueue.getNumberOfClients() + mainQueue.getNumberOfClients() == 100) {
            System.out.println("\n\nOops! The queue is full.");

            return;
        }

        System.out.println("\nName:");

        while (true) {
            name = scanner.nextLine();

            if (name.isBlank() || name.length() < 4) {
                System.out.println("Error: name invalid\n\nTry again");

                continue;
            }

            break;
        }

        System.out.println("\nClient is prioritary? (y/n)");
        
        while (true) {
            String input = scanner.nextLine();

            switch (input) {
                case "y":
                    isPrioritary = true;
                    break;
                case "n":
                    isPrioritary = false;
                    break;

                default:
                    System.out.println("Error: invalid input\n\nTry again:");
                    continue;
            }

            break;
        }
        
        client = new Client(name, isPrioritary);

        if (isPrioritary) {
            prioritaryQueue.addClient(client);
        } else {
            mainQueue.addClient(client);
        }
    }

    public void nextClient() {
        Client nextClient = null;

        if (prioritaryQueue.getNumberOfClients() + mainQueue.getNumberOfClients() == 0) {
            System.out.println("\n\nOops! The queue is empty.");

            return;
        }

        if (prioritaryQueue.getNumberOfClients() != 0) {
            nextClient = prioritaryQueue.removeClient();
        } else {
            nextClient = mainQueue.removeClient();
        }

        System.out.println("\n\nClient name: " + nextClient.getName());
    }

    private void cleanQueueClients() {
        String output = "\n\nIn order, the clients:\n";
        
        if (prioritaryQueue.getNumberOfClients() + mainQueue.getNumberOfClients() == 0) {
            System.out.println("\n\nOops! The queue is empty.");

            return;
        }

        while (prioritaryQueue.getNumberOfClients() + mainQueue.getNumberOfClients() != 0) {
            if (prioritaryQueue.getNumberOfClients() != 0) {
                output += prioritaryQueue.removeClient().getName();
            } else {
                output += mainQueue.removeClient().getName();
            }

            if (prioritaryQueue.getNumberOfClients() + mainQueue.getNumberOfClients() != 0) {
                output += ", ";
            }
        }

        System.out.println(output);
    }
}
