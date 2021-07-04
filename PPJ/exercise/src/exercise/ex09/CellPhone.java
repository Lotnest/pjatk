package exercise.ex09;

public class CellPhone extends Phone {

    private int[] callHistory = new int[10];

    public CellPhone(String communicationInterface, String color) {
        super(communicationInterface, color);
    }

    public int[] getCallHistory() {
        return callHistory;
    }

    public void setCallHistory(int[] callHistory) {
        if (callHistory.length > 10) {
            throw new IllegalArgumentException("Call history can not have more than 10 numbers");
        }
        this.callHistory = callHistory;
    }
}
