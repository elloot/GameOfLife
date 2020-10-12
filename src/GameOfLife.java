public class GameOfLife {
    private final Evolutioner evolutioner;
    private final Grid grid;

    public GameOfLife(int width, int height) {
        grid = new Grid(width, height);
        evolutioner = new Evolutioner(grid);
    }

    public void render(int[] pixels) {
        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                pixels[y * grid.getWidth() + x] = grid.getCell(x, y).isAlive() ? 0xFFFFFF : 0x000000;
            }
        }
    }

    public void update() {
        evolutioner.step();
    }
}
