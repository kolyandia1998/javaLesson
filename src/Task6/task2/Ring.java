package Task6.task2;

import Task5.task2.Round;

public class Ring extends Round {

    public Ring(double xCenter, double yCenter, double radius, double innerRadius) throws Exception {
        super(xCenter, yCenter, radius);
        TrowIfInvalidRadius(innerRadius);
        TrowIfInvalidInnerRadius(innerRadius);
        this.innerRadius = innerRadius;
    }


    protected void TrowIfInvalidInnerRadius(double radius) throws Exception {
        if (innerRadius >= getRadius()) {
            throw new Exception("Внутренний радиус должен быть меньше внешнего");
        }
    }

    private double innerRadius;

    public double getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(double innerRadius) throws Exception {
        TrowIfInvalidRadius(innerRadius);
        TrowIfInvalidInnerRadius(innerRadius);
        this.innerRadius = innerRadius;
    }

    public double ringSquare() {
        return getCircleS() - Math.PI * Math.pow(innerRadius, 2);
    }

    public double getInnerCircleLong() {
        return 2 * Math.PI * innerRadius;
    }

}
