package Task14;

public class ID {
    private static long idCounter = 1;
    public static synchronized long createID()
    {
        return idCounter++;
    }
    protected static long getID () {
      return  createID();
    }
}
