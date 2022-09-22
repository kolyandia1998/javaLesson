package Task14;

import static Task14.ID.getID;

public abstract class Unit {
    private ID identifier = new ID();
    protected long id = getID();

    protected long getId() {
        return id;
    }
}
