package Task14.Rewards;

import Task14.Unit;

public class Rewards extends Unit {
    private String Tittle;
    private String Description;

    public Rewards(String tittle, String description) {
        Tittle = tittle;
        Description = description;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
