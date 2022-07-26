package Task5.task3;

public class Triangle {
    private double A;
    private double B;
    private double C;

    public void setA(double A) throws Exception {
        if (A <= 0) {
            throw new Exception("Сторона треугольника должны быть больше 0");
        }

        this.A = A;

    }

    public void setB(double B) throws Exception {
        if (B <= 0) {
            throw new Exception("Сторона треугольника должны быть больше 0");
        }

        this.B = B;

    }

    public void setC(double C) throws Exception {
        if (C <= 0) {
            throw new Exception("Сторона треугольника должны быть больше 0");
        }
        this.C = C;
    }


     public double getPerimeter ()
     {
         return A+B+C;
     }
     public double getSquare () {
      double perim = getPerimeter();
      return Math.sqrt(perim*(perim-A)*(perim-B)*(perim-C));
     }
}
