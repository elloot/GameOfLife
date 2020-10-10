public class GameOfLife {
    Evolutioner evolutioner;

    public GameOfLife(int width, int height) {
        evolutioner = new Evolutioner(width, height);
    }

    public void render(int[] pixels) {
        for (int y = 0; y < evolutioner.getGrid().getHeight(); y++) {
            for (int x = 0; x < evolutioner.getGrid().getWidth(); x++) {
                pixels[y * evolutioner.getGrid().getWidth() + x] = evolutioner.getGrid().getCell(x, y).isAlive() ? 0xFFFFFF : 0x000000;
            }
        }
    }

    public void update() {
        evolutioner.step();
    }
}
