package scheduler;

public class TaskFactory {
    // create a normal timed task
    public static Task createTimedTask(String name, String start, String end, int priority) {
        int s = TimeUtils.parseHHMMToMinutes(start);
        int e = TimeUtils.parseHHMMToMinutes(end);
        return new Task(name, s, e, priority);
    }
}
