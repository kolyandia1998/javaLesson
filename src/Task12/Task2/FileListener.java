package Task12.Task2;
import java.io.IOException;
import java.util.EventListener;
public interface FileListener extends EventListener {
    public void onModified(FileEvent event) throws IOException;
}