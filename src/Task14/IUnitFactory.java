package Task14;

import java.time.LocalDate;

public interface IUnitFactory {
    public Unit CreateUser (String firstName, String lastName, LocalDate birthDay);
    public Unit CreateReward (String tittle, String description);
}
