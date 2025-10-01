package scheduler;

import java.io.Serializable;
import java.util.UUID;

public class Task implements Serializable, Comparable<Task> {
    private static final long serialVersionUID = 1L;
    private final String id;
    private final String name;
    private final int startMin; // minutes from midnight
    private final int endMin;
    private final int priority; // 1 high, 2 med, 3 low
    private boolean completed;

    public Task(String name, int startMin, int endMin, int priority) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.startMin = startMin;
        this.endMin = endMin;
        this.priority = priority;
        this.completed = false;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getStartMin() { return startMin; }
    public int getEndMin() { return endMin; }
    public int getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean c) { this.completed = c; }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(this.startMin, o.startMin);
    }

    @Override
    public String toString() {
        return String.format("%s [%s - %s] pr=%d %s", name,
                TimeUtils.toHHMM(startMin), TimeUtils.toHHMM(endMin),
                priority, completed ? "(done)" : "");
    }
}
