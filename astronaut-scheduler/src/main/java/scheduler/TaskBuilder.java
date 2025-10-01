package scheduler;

public class TaskBuilder {
    private String name;
    private String start = "00:00";
    private String end = "00:01";
    private int priority = 2;

    public TaskBuilder name(String name) { this.name = name; return this; }
    public TaskBuilder start(String s) { this.start = s; return this; }
    public TaskBuilder end(String e) { this.end = e; return this; }
    public TaskBuilder priority(int p) { this.priority = p; return this; }

    public Task build() {
        return TaskFactory.createTimedTask(name, start, end, priority);
    }
}
