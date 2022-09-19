package Task12.Task2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static Task12.Task2.Originator.GetAllFiles;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Originator originator = new Originator("C:\\BackUp", "C:\\log\\logs.txt", "C:\\directory");

        Path Target = Paths.get(originator.getBack());
        Path Source = Paths.get(originator.getFolder());
        Path Logs = Paths.get(originator.getLogPath());

        ArrayList<File> fileList = new ArrayList<>();

        GetAllFiles(Source, fileList);

        originator.files = fileList;

        System.out.println("Введите 1 для режима наблюдателя  \nВведите 2 для режима восстановления");

        String key = reader.readLine();

        if (key.equals("1")) {
            Logs.getParent().toFile().mkdirs();
            Logs.toFile().createNewFile();
            FileWriter writer = new FileWriter(Logs.toFile());
            originator.logFiles(writer, Source, Target);
        } else if (key.equals("2")) {
            System.out.println("Введите дату восстановления в формате 'гггг-дд-ммTч-м-с'");
            String date = reader.readLine();
            try {
                originator.GetBackup(Target, date);
                System.out.println("Данные восстановлены");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Точка восстановления отсутствует");
            }
        } else {
            System.out.println("Такого ключа не существует");
        }
    }
}
