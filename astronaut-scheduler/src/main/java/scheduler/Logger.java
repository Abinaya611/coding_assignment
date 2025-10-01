package scheduler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_FILE = "logs/app.log";
    public static synchronized void log(String msg) {
        try {
            new File("logs").mkdirs();
            try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
                fw.write(LocalDateTime.now() + " - " + msg + System.lineSeparator());
            }
        } catch (IOException ignored) {}
    }
}
