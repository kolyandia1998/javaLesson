package Task3.task2;

public class task2 {
    public static void main(String[] args) {
        int[][][] input = new int[3][3][3];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                for (int q = 0; q < 3; q++) {
                    input[i][j][q] = (int) (Math.random() * 12 - 5);
                    System.out.println(input[i][j][q]);
                }
            }

        }


        System.out.println("Массив после замены");
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                for (int q = 0; q < 3; q++) {
                    if (input[i][j][q] > 0) {
                        input[i][j][q] = 0;
                    }

                    System.out.println(input[i][j][q]);
                }
            }

        }


    }


}

