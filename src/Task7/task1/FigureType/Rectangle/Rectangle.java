package Task7.task1.FigureType.Rectangle;

import Task7.task1.Figure;
import Task7.task1.FigureType.Rectangle.SizeExeption.SizeException;

public class Rectangle extends Figure {
    private Double height, width;
    private final String name = "Rectangle";

    private void checkSize(Double size) throws SizeException {
        if (size <= 0) {
            throw new SizeException("Размеры не могут быть отрицательными");
        }
    }
    public Rectangle(Double x, Double y, Double height, Double width) throws SizeException {
        super(x, y);
        checkSize(height);
        checkSize(width);
        this.height = height;
        this.width = width;
    }
    public Double getHeight() {

        return height;
    }
    public void setHeight(Double height) throws SizeException {
        checkSize(height);
        this.height = height;
    }
    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) throws SizeException {
        checkSize(width);
        this.width = width;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "name=" + name +
                ", width=" + width +
                ", height='" + height + '\'' +
                '}';
    }
}
