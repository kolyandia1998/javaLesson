package Task3.task3;

public class task3 {
    public static void main(String[] args) {
        int[] input = new int[10];
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random() * 12 - 5);
            if (input[i] >= 0) {
                sum += input[i];
            }
            System.out.println(input[i]);
        }

        System.out.println("Сумма неотрицательных элементов");
        System.out.println(sum);
    }
}
