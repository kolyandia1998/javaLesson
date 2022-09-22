package Task12.Task2;
import Task7.task1.FigureType.Ring.RadiusException.RadiusException;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static Task12.Task2.Copy.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Originator originator = new Originator("C:\\BackUp", "C:\\log\\logs.txt", "C:\\directory");
        while (true) {
            System.out.println("Введите 1 для Режим наблюдателя\nВведите 2 для режима бэкап");
            switch (reader.readLine()) {
                case ("1"):
                    System.out.println("Режим наблюдателя запущен");
                    FileWriter writer = new FileWriter(originator.getLogPath().toFile());
                    FolderWatcher folderWatcher = new FolderWatcher(originator.getFolder().toFile(), writer);
                    folderWatcher.addListener(originator);
                    folderWatcher.watch();
                    System.out.println("Нажмите любую кнопку для завершения");
                    reader.readLine();
                    folderWatcher.watchClose();
                    folderWatcher.removeListener(originator);
                    break;
                case ("2"):
                    System.out.println("Введите дату точки восстановления");
                    String date = reader.readLine();
                    try {
                        originator.GetBackup(date);
                        System.out.println("Восстановлено успешно");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Точка восстановления отсутствует");
                    }
                    break;
            }
        }
    }
}
