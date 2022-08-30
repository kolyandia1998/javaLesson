package Task11.task3;

public class TwoDPointWithHash {
    public int x, y;

    public TwoDPointWithHash(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int xAfterMove = this.x << 16;
        return xAfterMove | y;
    }
}
