public class Grid {
    private final Cell[] cells;
    private final int WIDTH;
    private final int HEIGHT;
    private final double WEIGHT;
    private final double DEFAULT_WEIGHT = 0.5;

    public Grid(int width, int height, double weight) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.cells = new Cell[width*height];
        this.WEIGHT = weight > 0 && weight < 1 ? weight : DEFAULT_WEIGHT;
        this.populate();
    }

    public Grid(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.cells = new Cell[width*height];
        this.WEIGHT = DEFAULT_WEIGHT;
        this.populate();
    }

    public Cell[] getNeighbours(int x, int y) {
        Cell[] neighbours = new Cell[9];

        int index = 0;

        // adds each neighbour of the current cell to an array
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // should probably move the check to see if a supposed neighbour actually exists to a separate function
                if (!(i == 0 && j == 0) && (y + i >= 0 && x + j >= 0) && (y + i < this.HEIGHT && x + j < this.WIDTH))
                    neighbours[index] = cells[((y + i) * this.WIDTH) + (x + j)];
                index++;
            }
        }

        return neighbours;
    }

    private void populate() {
        for (int i = 0; i < this.WIDTH * this.HEIGHT; i++) {
            cells[i] = new Cell(Math.random() > this.WEIGHT, true);
        }
    }

    public void setCellSurvival(int x, int y, boolean willSurvive) {
        cells[y * this.WIDTH + x].setSurvival(willSurvive);
    }

    public void updateCells() {
        for (int i = 0; i < this.WIDTH*this.HEIGHT; i++) {
            cells[i].update();
        }
    }

    public Cell getCell(int x, int y) {
        return cells[(y * this.WIDTH) + x];
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
}
