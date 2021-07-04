package exercise.ex06.ex02;

public class LetterThread extends Thread {

    private final String text;
    private final long id;
    private int lettersPrinted = 0;

    public LetterThread(String text, long id) {
        this.text = text;
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    public int getLettersPrinted() {
        return lettersPrinted;
    }

    public void run() {
        for (int i = lettersPrinted; i < text.length(); i++) {
            if (!isInterrupted()) {
                System.out.println(this + ": " + text.charAt(i));
                lettersPrinted++;
            } else {
                System.out.println("Interrupted " + this);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "LetterThread" + id;
    }
}
