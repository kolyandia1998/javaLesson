package Task7.task4.Bonuses;

import static Task7.task4.Player.increaseLife;

public class Bonuses {
    private String name;

    public String getName() {
        return name;
    }

    public void giveLife() {
        increaseLife();
    }

    private int X;
    private int Y;

    public static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }

    private void createRandomlyLocation(int maxWidth, int maxHeight) {
        this.X = rnd(maxWidth);
        this.Y = rnd(maxHeight);
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
