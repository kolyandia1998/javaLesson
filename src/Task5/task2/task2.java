package Task5.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task2 {
    public static void main(String[] args) throws Exception {
        Round circle = new Round();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите радиус");
        circle.setRadius(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("Введите X координату центра");
        circle.setXCenter(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("Введите Y координату центра");
        circle.setYCenter(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("Площадь равна:" + circle.getCircleS());
        circle.getCircleS();
        System.out.println("Длина равна:" + circle.getCircleLong());

    }
}
