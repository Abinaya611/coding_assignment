package scheduler;

public class ConsoleNotifier implements Notifier {
    @Override
    public void onConflict(Task existing, Task incoming) {
        System.out.println("NOTIFIER: Conflict detected: '" + incoming.getName() + "' conflicts with '" + existing.getName() + "'");
    }
    @Override
    public void onTaskAdded(Task t) {
        System.out.println("NOTIFIER: Task added -> " + t);
    }
}
