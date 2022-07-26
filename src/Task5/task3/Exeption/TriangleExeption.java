package Task5.task3.Exeption;

public class TriangleExeption  extends Exception{



    public TriangleExeption() {
    }

    public TriangleExeption(String message) {
        super(message);
    }

    public TriangleExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleExeption(Throwable cause) {
        super(cause);
    }

    public TriangleExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}


