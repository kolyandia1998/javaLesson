package Task12.Task2;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import static Task12.Task2.Copy.MakeCopy;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
public class Originator {
    public ArrayList<File> files;
    private String Back;
    private String LogPath;
    private String Folder;

    public String getBack() {
        return Back;
    }

    public void ss(Path s, Path g) {

    }

    public String getLogPath() {
        return LogPath;
    }

    public String getFolder() {
        return Folder;
    }

    private final WatchService watchService = FileSystems.getDefault().newWatchService();

    public Originator(String Back, String logPath, String Folder) throws IOException {
        this.Back = Back;
        this.LogPath = logPath;
        this.Folder = Folder;
    }

    public static void GetAllFiles(Path source, ArrayList<File> files) {
        File[] sourceFiles = source.toFile().listFiles();
        for (File file : sourceFiles) {
            if (file.isFile()) {
                files.add(file);
            } else {
                GetAllFiles(file.toPath(), files);
            }
        }
    }

    public void logFiles(FileWriter writer, Path Source, Path Target) throws IOException, InterruptedException {
        LocalDateTime localDateTimer = LocalDateTime.now();
        MakeCopy(Source, Paths.get(Target.toString() + "\\" + Source.toFile().getName() + "_" +
                localDateTimer.toLocalDate() + "T" + localDateTimer.toLocalTime().getHour() + "-" + localDateTimer.toLocalTime().getMinute() + "-" +
                localDateTimer.toLocalTime().getSecond()));
        for (File file : files) {
            Paths.get(file.toURI()).getParent().register(watchService, ENTRY_MODIFY);
        }
        WatchKey key;
        boolean poll = true;
        while (poll) {
            key = watchService.take();

            for (WatchEvent event : key.pollEvents()) {
                LocalDateTime localDateTime = LocalDateTime.now();
                MakeCopy(Source, Paths.get(Target.toString() + "\\" + Source.toFile().getName() + "_" +
                        localDateTime.toLocalDate() + "T" + localDateTime.toLocalTime().getHour() + "-" + localDateTime.toLocalTime().getMinute() + "-" +
                        localDateTime.toLocalTime().getSecond()));
                writer.write("Event kind:" + event.kind() + ". File affected: " + event.context() + "." + "\n");
                writer.flush();
            }
            key.reset();
        }
        writer.close();
    }

    private String GetDateTime(String path) {
        return path.substring(path.lastIndexOf("_") + 1, path.length());
    }

    public void GetBackup(Path BackupSource, String date) throws IOException, NullPointerException, ArrayIndexOutOfBoundsException {
        FilenameFilter filterDate = (dir, name) -> name.contains(date);
        Path dateBackup = Paths.get(BackupSource.toFile().listFiles(filterDate)[0].toString());
        for (File file : files) {
            FilenameFilter filterName = (dir, name) -> name.contains(file.getName());
            File test = dateBackup.toFile().listFiles(filterName)[0];
            file.delete();
            MakeCopy(test.toPath(), file.toPath().getParent());
        }
    }
}




