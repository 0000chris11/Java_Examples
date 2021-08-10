package file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.util.List;

class WatchServiceTest {

    public static void main(String[] args) throws IOException {
        // new WatchServiceTest();
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = Paths.get("resources");

        dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

        while (true) {
            WatchKey key = null;
            boolean valid = false;
            try {
                key = watcher.take();

                List<WatchEvent<?>> eventList = key.pollEvents();
                for (WatchEvent<?> event : eventList) {
                    Kind<?> type = event.kind();
                    Path file = (Path) event.context();
                    String message = "(FILE: " + file.getFileName() + ")";
                    if (type == ENTRY_CREATE) {
                        System.out.println("ENTRY_CREATE " + message);
                    } else if (type == ENTRY_MODIFY) {
                        System.out.println("ENTRY_MODIFY " + message);
                    } else if (type == ENTRY_DELETE) {
                        System.out.println("ENTRY_DELETE " + message);
                    }
                }

                valid = key.reset();
                if (!valid) {
                    break;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }
    }
}
