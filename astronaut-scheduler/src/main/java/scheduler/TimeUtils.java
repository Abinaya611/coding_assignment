package scheduler;

public class TimeUtils {
    public static int parseHHMMToMinutes(String hhmm) {
        if (hhmm == null) throw new IllegalArgumentException("Null time");
        String[] parts = hhmm.trim().split(":");
        if (parts.length != 2) throw new IllegalArgumentException("Invalid time: " + hhmm);
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        if (hh < 0 || hh > 23 || mm < 0 || mm > 59) throw new IllegalArgumentException("Invalid time: " + hhmm);
        return hh * 60 + mm;
    }
    public static String toHHMM(int minutes) {
        int hh = (minutes / 60) % 24;
        int mm = minutes % 60;
        return String.format("%02d:%02d", hh, mm);
    }
}
