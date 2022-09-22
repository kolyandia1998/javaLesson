package Task12.Task2;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static Task12.Task2.Copy.MakeCopy;

public class Originator implements FileListener {
    private String getDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.toLocalDate() + "T" + localDateTime.toLocalTime().getHour() +
                "-" + localDateTime.toLocalTime().getMinute() + "-" + localDateTime.toLocalTime().getSecond();
    }
    private ArrayList<File> Files = new ArrayList<>();
    private Path Back;
    private Path LogPath;
    public void setBack(Path back) {
        Back = back;
    }
    public void setLogPath(Path logPath) {
        LogPath = logPath;
    }
    public void setFolder(Path folder) {
        Folder = folder;
    }
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
    @Override
    public void onModified(FileEvent event) throws IOException {
        MakeCopy(Folder, Paths.get(Back.toString() + "\\" + Folder.toFile().getName() + "_" + getDateTime()));
    }
}





