package MyLib;

public class MyMath {
    public static int factorial (int value) {
        if (value == 1)
        {return  1;}
        return  factorial(value -1) * value;
    }

    public static int Exponentiation (int value, int degree) {
        if (degree == 0)
            return 1;
        else if (degree==1)
            return value;
        int res = 1;
        for (int i=0 ; i < degree; i++) {
            res = value * res;
        }
        return res;
    }
}