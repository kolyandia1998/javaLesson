package Task7.task1.FigureType.Ring;

import Task7.task1.Figure;
import Task7.task1.FigureType.Ring.RadiusException.RadiusException;

public class Ring extends Figure {
    private Double innerRadius, outerRadius;
    private final String name = "Ring";

    public Double getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(Double innerRadius) throws RadiusException {
        throwIfInvalidRadius(innerRadius);
        trowIfInvalidInnerRadius(innerRadius);
        this.innerRadius = innerRadius;
    }

    public Double getOuterRadius() {

        return outerRadius;
    }

    public void setOuterRadius(Double outerRadius) throws RadiusException {
        throwIfInvalidRadius(outerRadius);
        this.outerRadius = outerRadius;
    }

    @Override
    public String getName() {
        return name;
    }

    private void throwIfInvalidRadius(Double radius) throws RadiusException {
        if (radius <= 0) {
            throw new RadiusException("Радиус должен быть больше 0");
        }
    }

    private void trowIfInvalidInnerRadius(Double innerRadius) throws RadiusException {
        if (innerRadius >= outerRadius) {
            throw new RadiusException("Внутренний радиус должен быть меньше внешнего");
        }
    }

    public Ring(Double x, Double y, Double innerRadius, Double outerRadius) throws RadiusException {
        super(x, y);
        throwIfInvalidRadius(innerRadius);
        throwIfInvalidRadius(outerRadius);
        trowIfInvalidInnerRadius(innerRadius);
    }

    @Override
    public String toString() {
        return "Ring{" +
                "name=" + name +
                ", outerRadius=" + outerRadius +
                ", innerRadius='" + innerRadius + '\'' +
                '}';
    }
}
