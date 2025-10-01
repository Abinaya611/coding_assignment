package scheduler;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScheduleManager {
    private static final String DATA_FILE = "data/tasks.ser";
    private static final ScheduleManager instance = new ScheduleManager();

    private final List<Task> tasks = new ArrayList<>();
    private final List<Notifier> notifiers = new ArrayList<>();

    private ScheduleManager() {
        load();
    }

    public static ScheduleManager getInstance() { return instance; }

    public synchronized void addNotifier(Notifier n) { notifiers.add(n); }
    public synchronized void removeNotifier(Notifier n) { notifiers.remove(n); }

    public synchronized void addTask(Task t) throws IllegalArgumentException, IOException {
        // Validate
        if (t.getEndMin() <= t.getStartMin()) throw new IllegalArgumentException("End must be after start");
        // Check conflict
        Collections.sort(tasks);
        Task conflict = ConflictDetector.findConflict(tasks, t);
        if (conflict != null) {
            for (Notifier n : notifiers) n.onConflict(conflict, t);
            throw new IllegalArgumentException("Task conflicts with existing task: " + conflict.getName());
        }
        // insert keeping sorted order
        int idx = 0;
        while (idx < tasks.size() && tasks.get(idx).getStartMin() <= t.getStartMin()) idx++;
        tasks.add(idx, t);
        persist();
        for (Notifier n : notifiers) n.onTaskAdded(t);
        Logger.log("Added task: " + t);
    }

    public synchronized List<Task> listTasks() {
        Collections.sort(tasks);
        return new ArrayList<>(tasks);
    }

    public synchronized boolean removeTaskByName(String name) throws IOException {
        Task found = null;
        for (Task t : tasks) if (t.getName().equalsIgnoreCase(name)) { found = t; break; }
        if (found != null) {
            tasks.remove(found);
            persist();
            Logger.log("Removed task: " + found);
            return true;
        }
        return false;
    }

    public synchronized void markComplete(String name) throws IOException {
        for (Task t : tasks) {
            if (t.getName().equalsIgnoreCase(name)) {
                t.setCompleted(true);
                persist();
                Logger.log("Marked complete: " + t);
                return;
            }
        }
        throw new IllegalArgumentException("Task not found: " + name);
    }

    private void persist() {
        try {
            File dir = new File("data"); dir.mkdirs();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
                oos.writeObject(tasks);
            }
        } catch (IOException e) {
            Logger.log("Persist error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void load() {
        File f = new File(DATA_FILE);
        if (!f.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object o = ois.readObject();
            if (o instanceof List) {
                tasks.clear();
                tasks.addAll((List<Task>) o);
            }
        } catch (Exception e) {
            Logger.log("Load error: " + e.getMessage());
        }
    }
}
