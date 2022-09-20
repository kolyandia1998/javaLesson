package Task12.Task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copy {
    private static void CopyFile(Path Source, Path Target) throws IOException {
        if (!Target.getParent().toFile().exists()) {
            Target.getParent().toFile().mkdirs();
        }
        Files.copy(Source, Target);
    }

    private static void CopyDirectory(Path Source, Path Target) throws IOException {
        if (!Target.toFile().exists()) {
            Target.toFile().mkdirs();
        }
        for (String str : Source.toFile().list()) {
            MakeCopy(new File(Source.toFile(), str).toPath(), new File(Target.toFile(), str).toPath());
        }
    }

    public static void MakeCopy(Path Source, Path Target) throws IOException {
        if (Source.toFile().isDirectory()) {
            CopyDirectory(Source, Target);
        } else CopyFile(Source, Target);
    }
}
