package Task7.task1.FigureType.Rectangle.SizeExeption;

public class SizeException extends  Exception{
    public SizeException() {
    }

    public SizeException(String message) {
        super(message);
    }

    public SizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SizeException(Throwable cause) {
        super(cause);
    }

    public SizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
