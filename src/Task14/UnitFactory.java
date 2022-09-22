package Task14;

import Task14.IUnitFactory;
import Task14.Unit;

import java.time.LocalDate;

public class UnitFactory implements IUnitFactory {
    @Override
    public Unit CreateUser(String firstName, String lastName, LocalDate birthDay) {
        return null;
    }
    @Override
    public Unit CreateReward(String tittle, String description) {
        return null;
    }
}
