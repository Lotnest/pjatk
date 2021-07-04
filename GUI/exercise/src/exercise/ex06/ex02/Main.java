package exercise.ex06.ex02;

public class Main {

    public static void main(String[] args) {
        Letters letters = new Letters("Main", 10);
        letters.start();
        try {
            letters.interrupt();
            System.out.println("Sleeping for 5000 ms");
            Thread.sleep(5000);
            System.out.println("No longer sleeping");
            letters.getThreads().forEach(thread -> System.out.println(thread + ": " + thread.getLettersPrinted()));
        } catch (InterruptedException ignored) {
        }
    }
}
