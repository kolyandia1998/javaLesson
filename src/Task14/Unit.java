package Task14;

public class Unit  {
   static int NextID = 0;
  protected int id = ++NextID;
  public int getId() {
      return id;
  }
    public void setID (int id) {
        this.id = id;
    }
}
