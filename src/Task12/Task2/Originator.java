package Task12.Task2;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.annotation.Target;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static Task12.Task2.Copy.MakeCopy;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class Originator {
    private String getDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.toLocalDate() + "T" + localDateTime.toLocalTime().getHour() +
                "-" + localDateTime.toLocalTime().getMinute() + "-" + localDateTime.toLocalTime().getSecond();
    }
    private ArrayList<File> Files = new ArrayList<>();
    private Path Back;
    private Path LogPath;
    private Path Folder;
    public Path getBack() {
        return Back;
    }
    public Path getLogPath() {
        return LogPath;
    }
    public Path getFolder() {
        return Folder;
    }
    private final WatchService watchService = FileSystems.getDefault().newWatchService();
    public Originator(String Back, String logPath, String Folder) throws IOException {
        this.Back = Paths.get(Back);
        this.LogPath = Paths.get(logPath);
        this.Folder = Paths.get(Folder);
    }
    public ArrayList<File> getFiles() {
        return Files;
    }
    private static void InternalGetAllFiles(Path source, ArrayList<File> files) {
        File[] sourceFiles = source.toFile().listFiles();
        for (File file : sourceFiles) {
            if (file.isFile()) {
                files.add(file);
            } else {
                InternalGetAllFiles(file.toPath(), files);
            }
        }
    }
    public void AddFilesFromSource() {
        InternalGetAllFiles(Folder, Files);
    }
    public void LogFiles(FileWriter writer) throws IOException, InterruptedException {
        MakeCopy(Folder, Paths.get(Back.toString() + "\\" + Folder.toFile().getName() + "_" + getDateTime()));
        for (File file : Files) {
            Paths.get(file.toURI()).getParent().register(watchService, ENTRY_MODIFY);
        }
        WatchKey key;
        boolean poll = true;
        while (poll) {
            key = watchService.take();
            for (WatchEvent event : key.pollEvents()) {
                MakeCopy(Folder, Paths.get(Back.toString() + "\\" + Folder.toFile().getName() + "_" + getDateTime()));
                writer.write("Event kind:" + event.kind() + ". File affected: " + event.context() + "." + "\n");
                writer.flush();
            }
            poll = key.reset();
        }
        writer.close();
    }
    private void DeletedDirectory(Path Directory) {
        for (File file : Directory.toFile().listFiles()) {
            if (file.isDirectory()) {
                DeletedDirectory(file.toPath());
                file.delete();
            } else {
                file.delete();
            }
        }
    }
    public void GetBackup(String date) throws IOException, NullPointerException, ArrayIndexOutOfBoundsException {
        FilenameFilter filterDate = (dir, name) -> name.contains(date);
        Path FolderBackup = Paths.get(Back.toFile().listFiles(filterDate)[0].toString());
        DeletedDirectory(Folder);
        MakeCopy(FolderBackup, Folder);
    }
}





