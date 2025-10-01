package scheduler;

import java.util.List;

public class ConflictDetector {
    // Given sorted list by startMin, check if 't' conflicts with any.
    // Efficiently checks neighbors where inserted.
    public static Task findConflict(List<Task> sorted, Task t) {
        if (sorted.isEmpty()) return null;
        int lo = 0, hi = sorted.size() - 1;
        int idx = sorted.size(); // default insert at end
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            Task m = sorted.get(mid);
            if (m.getStartMin() < t.getStartMin()) {
                lo = mid + 1;
            } else {
                idx = mid; hi = mid - 1;
            }
        }
        // check previous and current neighbor
        if (idx - 1 >= 0) {
            Task prev = sorted.get(idx - 1);
            if (overlaps(prev, t)) return prev;
        }
        if (idx < sorted.size()) {
            Task next = sorted.get(idx);
            if (overlaps(next, t)) return next;
        }
        return null;
    }

    public static boolean overlaps(Task a, Task b) {
        return a.getStartMin() < b.getEndMin() && b.getStartMin() < a.getEndMin();
    }
}
