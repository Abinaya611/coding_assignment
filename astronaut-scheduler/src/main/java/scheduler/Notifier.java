package scheduler;

public interface Notifier {
    void onConflict(Task existing, Task incoming);
    void onTaskAdded(Task t);
}
