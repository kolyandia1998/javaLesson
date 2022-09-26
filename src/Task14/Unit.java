package Task14;

import static Task14.ID.getID;

public abstract class Unit {
    private ID identifier = new ID();
    public int id = getID();

    public int getId() {
        return id;
    }
}
