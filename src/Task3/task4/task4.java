package Task3.task4;

public class task4 {
    public static void main(String[] args) {
        int[][] input = new int[5][5];
        int sum = 0;
        for (int x = 0; x < input.length; x++) {
            for (int y = 0; y < input.length; y++) {
                input[x][y] = (int) (Math.random() * 12 - 5);
                System.out.println(input[x][y]);
            }
        }


        for (int x = 0; x < input.length; x++) {
            for (int y = 0; y < input.length; y++) {
                if ((x + y) % 2 == 0) {
                    sum += input[x][y];
                }
            }
        }
        System.out.println("Сумма четных элементов = " + sum);
    }
}
