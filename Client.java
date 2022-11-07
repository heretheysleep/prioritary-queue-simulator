public class Client {
    private String name;
    private boolean isPrioritary;

    public Client(String name, boolean isPrioritary) {
        this.name = name;
        this.isPrioritary = isPrioritary;
    }

    public String getName() {
        return name;
    }

    public boolean isPrioritary() {
        return isPrioritary;
    }
}
