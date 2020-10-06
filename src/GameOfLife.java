public class GameOfLife {
    Evolutioner evolutioner;

    public GameOfLife(int width, int height) {
        evolutioner = new Evolutioner(width, height);
    }

    public void render(int[] pixels) {
        for (int i = 0; i < evolutioner.getGrid().getHeight(); i++) {
            for (int j = 0; j < evolutioner.getGrid().getWidth(); j++) {
                pixels[i * evolutioner.getGrid().getWidth() + j] = evolutioner.getGrid().getCell(i, j).isAlive() ? 0x000000 : 0xFFFFFF;
            }
        }
    }

    public void update() {
        evolutioner.step();
    }
}
