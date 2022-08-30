package Task11.task3;

public class task3 {
    public static void main(String[] args) {
        TwoDPointWithHash twoDPointWithHash = new TwoDPointWithHash(10, 10);
        TwoDPointWithHash twoDPointWithHash1 = new TwoDPointWithHash(1, 1);
        TwoDPointWithHash twoDPointWithHash2 = new TwoDPointWithHash(12, 1);
        TwoDPointWithHash twoDPointWithHash3 = new TwoDPointWithHash(13, 1);

        System.out.println(twoDPointWithHash.hashCode());
        System.out.println(twoDPointWithHash1.hashCode());
        System.out.println(twoDPointWithHash2.hashCode());
        System.out.println(twoDPointWithHash3.hashCode());
    }
}
