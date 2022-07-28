package Task7.task1;

public abstract class Figure {
    private String name;
    private Double X, Y;

    public Figure(Double x, Double y) {
        X = x;
        Y = y;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "name='" + name + '\'' +
                ", X=" + X +
                ", Y=" + Y +
                '}';
    }

    public String Draw() {

        return toString();
    }

    public Double getX() {
        return X;
    }

    public Double getY() {
        return Y;
    }

    public void setX(Double x) {
        X = x;
    }

    public void setY(Double y) {
        Y = y;
    }
}

