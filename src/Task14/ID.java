package Task14;

public class ID {
    private static int idCounter = 1;
    public static synchronized int createID()
    {
        return idCounter++;
    }
    protected static int getID () {
      return  createID();
    }
}
