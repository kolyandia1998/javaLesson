package Task7.task1.FigureType.Ring.RadiusException;

public class RadiusException extends Exception{
    public RadiusException() {
    }

    public RadiusException(String message) {
        super(message);
    }

    public RadiusException(String message, Throwable cause) {
        super(message, cause);
    }

    public RadiusException(Throwable cause) {
        super(cause);
    }

    public RadiusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
