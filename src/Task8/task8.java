package Task8;

import java.util.ArrayList;

public class task8 {
    public static void main(String[] args) throws Exception {

        DynamicArray<String> array = new DynamicArray<String>(10);
        int count = 0;
        for (int i = 0; i < 10; i++) {
            array.add("test" + count++);
            System.out.println(array.get(i) + "  Размер массива=" + array.size());
        }
        System.out.println("Реальный размер массива равен " + array.getRealSize());


        System.out.println("Добавим еще один эелемент в массив (массив в данный момент полный)");
        array.add("Тест на изменение реального размера");
        System.out.println("Размер массива равен " + array.size());
        System.out.println("Реальный размер массива равен " + array.getRealSize());

        System.out.println("Удалим 10 элемент");
        array.Remove(10);
        System.out.println("Размер массива=" + array.size());
        System.out.println("Реальный размер массива равен " + array.getRealSize());

        String[] str = new String[]{"qwer", "qwer", "qwert"};
        System.out.println("Добавим массив с 3 эелементами в коней");
        array.AddRange(str);
        System.out.println("Размер массива=" + array.size());


        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i) + " Размер массива=" + array.size());
        }


    }


}
