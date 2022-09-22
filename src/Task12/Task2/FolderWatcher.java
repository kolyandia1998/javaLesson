package Task12.Task2;

import static java.nio.file.StandardWatchEventKinds.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FolderWatcher implements Runnable {
    protected List<FileListener> listeners = new ArrayList<>();
    protected ArrayList<File> folders = new ArrayList<>();
    protected final File folder;
    protected static final List<WatchService> watchServices = new ArrayList<>();

    public FolderWatcher(File folder, FileWriter writer) {
        this.folder = folder;
        this.writer = writer;
    }

    private FileWriter writer;

    public void watch() {
        if (folder.exists()) {
            Thread thread = new Thread(this);
            thread.setDaemon(true);
            thread.start();
        }
    }

    @Override
    public void run() {
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            InternalGetAllFiles(folder.toPath(), folders);
            for (File file : folders) {
                Paths.get(file.toURI()).getParent().register(watchService, ENTRY_MODIFY);
            }
            watchServices.add(watchService);
            boolean poll = true;
            while (poll) {
                poll = pollEvents(watchService);
            }
        } catch (IOException | InterruptedException | ClosedWatchServiceException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void watchClose() {
        for (WatchService watchService : watchServices) {
            try {
                watchService.close();
            } catch (IOException e) {
            }
        }
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

    private void makeLogs(WatchEvent event, FileWriter writer) throws IOException {
        writer.write("Event kind:" + event.kind() + ". File affected: " + event.context() + "." + "\n");
        writer.flush();
    }

    protected boolean pollEvents(WatchService watchService) throws InterruptedException, IOException {
        WatchKey key = watchService.take();
        Path path = (Path) key.watchable();
        for (WatchEvent<?> event : key.pollEvents()) {
            makeLogs(event, writer);
            notifyListeners(event.kind(), path.resolve((Path) event.context()).toFile());
        }
        return key.reset();
    }

    protected void notifyListeners(WatchEvent.Kind<?> kind, File file) throws IOException {
        FileEvent event = new FileEvent(file);
        if (kind == ENTRY_MODIFY) {
            for (FileListener listener : listeners) {
                listener.onModified(event);
            }
        }
    }

    public FolderWatcher addListener(FileListener listener) {
        listeners.add(listener);
        return this;
    }

    public FolderWatcher removeListener(FileListener listener) {
        listeners.remove(listener);
        return this;
    }

    public List<FileListener> getListeners() {
        return listeners;
    }

    public FolderWatcher setListeners(List<FileListener> listeners) {
        this.listeners = listeners;
        return this;
    }
}
































 /*   public ArrayList<File> Folders = new ArrayList<>();
    private final WatchService watchService = FileSystems.getDefault().newWatchService();
    protected List<FileListener> listeners = new ArrayList<>();

    protected final Path folder;

    public FolderWatcher(Path folder) throws IOException {
        this.folder = folder;
    }


    public List<FileListener> getListeners() {
        return listeners;
    }

    public FolderWatcher addListener(FileListener listener) {
        listeners.add(listener);
        return this;
    }

    public FolderWatcher removeListener(FileListener listener) {
        listeners.remove(listener);
        return this;
    }

    public FolderWatcher setListeners(List<FileListener> listeners) {
        this.listeners = listeners;
        return this;
    }

    private void notifyListeners(WatchEvent.Kind<?> kind, File file) throws IOException {
        FileEvent event = new FileEvent(file);
        if (kind == ENTRY_MODIFY) {
            for (FileListener listener : listeners) {
                listener.onModified(event);
            }
        }
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



    public void pollEvents(WatchService watchService) throws InterruptedException, IOException {
        InternalGetAllFiles(folder,Folders);
        for (File file : Folders) {
            Paths.get(file.toURI()).getParent().register(this.watchService, ENTRY_MODIFY);
        }
        WatchKey key;
        Path path ;

        while ((key = this.watchService.take()) != null) {
            path = (Path) key.watchable();
            for (WatchEvent<?> event : key.pollEvents()) {
                notifyListeners(event.kind(), path.resolve((Path) event.context()).toFile());
            }
           key.reset();
        }
    }


    public void Watch () {
        if (folder.toFile().exists()) {
             Thread thread = new Thread(this);
             thread.setDaemon(true);
             thread.start();
        }

    }

    @Override
    public void run() {
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            Path path = Paths.get(folder.toFile().getAbsolutePath());
            path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
            boolean poll = true;
            while (poll) {
                poll = pollEvents(watchService);
            }
        } catch (IOException | InterruptedException | ClosedWatchServiceException e) {
            Thread.currentThread().interrupt();
        }
    }*/

