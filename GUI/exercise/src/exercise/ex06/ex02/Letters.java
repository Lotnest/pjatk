package exercise.ex06.ex02;

import java.util.HashSet;

public class Letters {

    private final String text;
    private final int threadCount;
    private boolean started = false;
    private final HashSet<LetterThread> threads = new HashSet<>();

    public Letters(String text, int threadCount) {
        this.text = text;
        this.threadCount = threadCount;
    }

    public String getText() {
        return text;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public boolean isStarted() {
        return started;
    }

    public HashSet<LetterThread> getThreads() {
        return threads;
    }

    public void start() {
        if (!started) {
            for (int i = 0; i < threadCount; i++) {
                LetterThread letterThread = new LetterThread(text, i);
                letterThread.start();
                threads.add(letterThread);
            }
            started = true;
        } else {
            throw new IllegalStateException("Letter threads already started");
        }
    }

    public void interrupt() {
        threads.forEach(Thread::interrupt);
    }
}
