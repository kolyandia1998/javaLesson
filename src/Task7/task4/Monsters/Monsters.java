package Task7.task4.Monsters;

import Task7.task4.IMoove;

import static Task7.task4.Player.decreaseLife;
import static Task7.task4.Player.increaseLife;

public class Monsters implements IMoove {

    private String name;
    private int X;
    private int Y;

    public void takeALife() {
        decreaseLife();
    }

    @Override
    public void moveRight() {
    }

    @Override
    public void moveLeft() {
    }

    @Override
    public void moveDown() {
    }

    @Override
    public void moveUp() {
    }
}
