package exercise.ex09;

public class Phone {

    private final String communicationInterface;
    private final String color;

    public Phone(String communicationInterface, String color) {
        this.communicationInterface = communicationInterface;
        this.color = color;
    }

    public String getCommunicationInterface() {
        return communicationInterface;
    }

    public String getColor() {
        return color;
    }

    public void call(String number) {
        System.out.println(number);
    }
}
