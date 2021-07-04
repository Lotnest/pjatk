package exercise.ex06.ex03;

public class StringTask implements Runnable {

    private final String textToConcatenate;
    private final int timesToConcatenate;
    private String result;
    private TaskState taskState;
    private Thread thread;

    public StringTask(String textToConcatenate, int timesToConcatenate) {
        this.textToConcatenate = textToConcatenate;
        this.timesToConcatenate = timesToConcatenate;
        result = textToConcatenate;
        taskState = TaskState.CREATED;
    }

    public String getTextToConcatenate() {
        return textToConcatenate;
    }

    public int getTimesToConcatenate() {
        return timesToConcatenate;
    }

    public String getResult() {
        return result;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public void start() {
        if (thread == null) {
            this.thread = new Thread(this);
            thread.start();
            taskState = TaskState.RUNNING;
        } else {
            throw new IllegalThreadStateException("Thread already started");
        }
    }

    public void abort() {
        if (taskState != TaskState.ABORTED) {
            taskState = TaskState.ABORTED;
            thread.interrupt();
        } else {
            throw new IllegalThreadStateException("Thread already aborted");
        }
    }

    public boolean isDone() {
        return taskState == TaskState.READY || taskState == TaskState.ABORTED;
    }

    @Override
    public void run() {
        if (!thread.isInterrupted()) {
            for (int i = 0; i < timesToConcatenate; i++) {
                //+ operator as it is more time consuming than using StringBuilder
                result = result + textToConcatenate;
            }
        }
    }
}

enum TaskState {

    CREATED,
    RUNNING,
    ABORTED,
    READY
}