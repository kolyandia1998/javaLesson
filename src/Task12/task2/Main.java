package Task12.task2;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import static Task12.task2.Originator.showFiles;
import static java.nio.file.StandardWatchEventKinds.*;




public class Main {

    public static void main(String[] args)  {
        Originator originator = new Originator();
        originator.setPath("C:\\directory");
        Path path = Paths.get(originator.getPath());
        ArrayList<File> filess = new ArrayList<>();
        showFiles(path.toFile().listFiles(), filess);
         originator.files = filess;
        for (File file:originator.files){
            System.out.println(file.getAbsolutePath());
        }





    }
}
