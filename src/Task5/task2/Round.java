package Task5.task2;

public class Round {

    private double xCenter;
    private double yCenter;

    private double radius;




    public Round(double xCenter, double yCenter, double radius) throws Exception {
        this.yCenter = yCenter;
        this.xCenter = xCenter;
        this.radius = radius;
    }


    public void setXCenter(double xCenter) {
        this.xCenter = xCenter;
    }

    public void setYCenter(double yCenter) {
        this.yCenter = yCenter;
    }


    public void setRadius(double radius) throws Exception {
        this.radius = radius;
    }

   public static boolean  positiveValid (Double input) {
       return input > 0;
    }

    public double getXCenter() {
        return xCenter;

    }

    public double getYCenter() {
        return yCenter;

    }

    public double getRadius() {
        return radius;
    }

    public double getCircleS() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getCircleLong() {
        return 2 * Math.PI * radius;
    }


}
