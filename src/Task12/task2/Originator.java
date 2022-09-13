package Task12.task2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Originator {
    private String path ;

    public String getPath() {
        return path;
    }

    public ArrayList<File> files ;


    public void setPath(String path) {
        this.path = path;
    }

   public    static    void showFiles (File[] files, ArrayList<File> arrayList)  {
        for (File file : files){
            if (file.isDirectory())
            { showFiles(Objects.requireNonNull(file.listFiles()), arrayList);}
            else {
                arrayList.add(file);
            }
        }
    }


}
