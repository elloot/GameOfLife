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
        /*cells[(y - 1) * this.WIDTH + (x - 1)];
        cells[(y - 1) * this.WIDTH + x];
        cells[(y - 1) * this.WIDTH + (x + 1)];*/

        int index = 0;

        // doesn't work for edge cases
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0) && (y + i >= 0 && x + j >= 0) && (y + i < this.HEIGHT && x + j < this.WIDTH))
                    neighbours[index] = cells[((y + i) * this.WIDTH) + (x + j)];
                index++;
            }
        }

        return neighbours;

        /*cells[y, (x - 1)];
        cells[y, (x + 1)];

        cells[(y + 1) * this.WIDTH + (x - 1)];
        cells[(y + 1) * this.WIDTH + x];
        cells[(y + 1) * this.WIDTH + (x + 1)];*/
    }

    private void populate() {
        for (int i = 0; i < this.WIDTH * this.HEIGHT; i++) {
            // Should willSurvive be true from start?
            cells[i] = new Cell(Math.random() > this.WEIGHT, true);
        }
    }

    public void setCellSurvival(int x, int y, boolean willSurvive) {
        cells[y * this.WIDTH + x].setSurvival(willSurvive);
    }

    public void execSurvival() {
        for (int i = 0; i < this.WIDTH*this.HEIGHT; i++) {
            cells[i].execSurvival();
        }
    }

    /*private boolean cellIsAlive(int i) {
        return cells[i].isAlive();
    }*/

    public Cell getCell(int x, int y) {
        return cells[y * this.WIDTH + x];
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
}
