package scheduler;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        ScheduleManager mgr = ScheduleManager.getInstance();
        mgr.addNotifier(new ConsoleNotifier());

        Scanner sc = new Scanner(System.in);
        System.out.println("Astronaut Daily Schedule Organizer (type 'help' for commands)");
        boolean running = true;
        while (running) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+", 2);
            String cmd = parts[0].toLowerCase();
            String rest = parts.length > 1 ? parts[1] : "";

            try {
                switch (cmd) {
                    case "help":
                        printHelp(); break;
                    case "add":
                        // format: add "Name" HH:MM HH:MM priority
                        // We'll parse naive: expecting quotes for name
                        addCommand(rest, mgr); break;
                    case "list":
                        List<Task> all = mgr.listTasks();
                        if (all.isEmpty()) System.out.println("(no tasks)");
                        else all.forEach(t -> System.out.println("- " + t));
                        break;
                    case "remove":
                        if (rest.isEmpty()) System.out.println("Usage: remove <name>");
                        else {
                            boolean ok = mgr.removeTaskByName(rest);
                            System.out.println(ok ? "Removed." : "Not found.");
                        }
                        break;
                    case "done":
                        if (rest.isEmpty()) System.out.println("Usage: done <name>");
                        else {
                            mgr.markComplete(rest);
                            System.out.println("Marked done.");
                        }
                        break;
                    case "exit":
                        running = false; break;
                    default:
                        System.out.println("Unknown command. Type 'help'.");
                }
            } catch (IllegalArgumentException | IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Bye.");
        sc.close();
    }

    static void printHelp() {
        System.out.println("Commands:");
        System.out.println("  add \"Task Name\" HH:MM HH:MM priority(1=high,2=med,3=low)");
        System.out.println("  list");
        System.out.println("  remove <Task Name>");
        System.out.println("  done <Task Name>");
        System.out.println("  exit");
    }

    static void addCommand(String rest, ScheduleManager mgr) throws IOException {
        // rest should start with "Name"
        rest = rest.trim();
        if (!rest.startsWith("\"")) {
            System.out.println("Name must be quoted. Example: add \"Spacewalk\" 09:00 10:00 1");
            return;
        }
        int closing = rest.indexOf('"', 1);
        if (closing < 1) {
            System.out.println("Invalid quoted name.");
            return;
        }
        String name = rest.substring(1, closing);
        String after = rest.substring(closing + 1).trim();
        String[] parts = after.split("\\s+");
        if (parts.length < 3) {
            System.out.println("Need start end priority. Example: 09:00 10:00 1");
            return;
        }
        String start = parts[0], end = parts[1];
        int priority = Integer.parseInt(parts[2]);
        Task t = new TaskBuilder().name(name).start(start).end(end).priority(priority).build();
        mgr.addTask(t);
        System.out.println("Task added: " + t);
    }
}
