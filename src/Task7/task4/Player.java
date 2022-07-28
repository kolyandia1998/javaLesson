package Task7.task4;

import java.util.Set;

public class Player implements IMoove {
    private static int life;
    private int X, Y;

    public Player() {
        life = 3;
        this.X = 0;
        this.Y = 0;
    }

    public static void increaseLife() {
        life++;
    }

    public static void decreaseLife() {
        life--;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public void moveRight() {
        X++;
    }

    @Override
    public void moveLeft() {
        X--;
    }

    @Override
    public void moveDown() {
        Y--;
    }

    @Override
    public void moveUp() {
        Y++;
    }
}
