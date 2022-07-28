package Task7.task4;

public class Ground {
    private int Width, Height;

    private void checkWidth(int Width, int Height) throws Exception {
        if (Width < Height) {
            throw new Exception("Ширина должна быть больше высоты");
        }
    }

    public final int[][] ground = new int[Width][Height];

    public Ground(int Height, int Width) throws Exception {
        checkWidth(Width, Height);
        this.Width = Width;
        this.Height = Height;
    }

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return Height;
    }
}
