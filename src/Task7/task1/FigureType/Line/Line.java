package Task7.task1.FigureType.Line;

import Task7.task1.Figure;
import Task7.task1.FigureType.Line.LineExeption.LineException;
import Task7.task1.FigureType.Line.LineExeption.LineException;

public class Line extends Figure {
    private final String name = "Line";
    private Double pointA, pointB;

    private void checkLine(Double pointA, Double PointB) throws LineException {
        if (pointA == PointB) {
            throw new LineException("Это не линия");
        }
    }

    public Line(Double x, Double y, Double pointA, Double pointB) throws LineException {
        super(x, y);
        checkLine(pointA, pointB);
        this.pointA = pointA;
        this.pointB = pointB;
    }

    @Override
    public String getName() {
        return name;
    }

    public Double getPointA() {
        return pointA;
    }

    public Double getPointB() {
        return pointB;
    }

    @Override
    public String toString() {
        return "Line{" +
                "name='" + name + '\'' +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }
}
