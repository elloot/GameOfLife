public class Grid {
    private final Cell[] cells;
    private final int WIDTH;
    private final int HEIGHT;
    private final double WEIGHT;

    public Grid(int width, int height, double weight) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.cells = new Cell[width*height];
        this.WEIGHT = weight > 0 && weight < 1 ? weight : 0.8;
        this.populate();
    }

    public Grid(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.cells = new Cell[width*height];
        this.WEIGHT = 0.8;
        this.populate();
    }

    private void populate() {
        for (int i = 0; i < this.WIDTH * this.HEIGHT; i++) {
            // Should toDo be true from start?
            cells[i] = new Cell(Math.random() > this.WEIGHT, true);
        }
    }

    private void setCellToDo(int i, boolean toDo) {
        cells[i].setToDo(toDo);
    }

    private void doToDo() {
        for (int i = 0; i < this.WIDTH*this.HEIGHT; i++) {
            cells[i].doToDo();
        }
    }

    private boolean cellIsAlive(int i) {
        return cells[i].isAlive();
    }

    public Cell getCell(int i) {
        return cells[i];
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
}
