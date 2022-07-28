package Task7.task4.Bonuses.TypeOfBonuses;

import Task7.task4.Bonuses.Bonuses;

import static Task7.task4.Player.increaseLife;

public class Apple extends Bonuses {
    private final String name = "Apple";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void giveLife() {
        giveLife();
        giveLife();
    }
}
