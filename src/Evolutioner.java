public class Evolutioner {
    private final Grid grid;

    public Evolutioner(int width, int height) {
        this.grid = new Grid(width, height);
    }

    public void step() {
        shouldSurvive();
        updateCells();
    }

    private void updateCells() {
        /*for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                grid.execSurvival();
            }
        }*/
        grid.execSurvival();
    }

    public Grid getGrid() {
        return grid;
    }

    private void shouldSurvive() {
        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                Cell[] neighbours = grid.getNeighbours(x, y);
                int liveNeighbours = numLiveNeighbours(neighbours);

                Cell currentCell = grid.getCell(x, y);

                if (currentCell.isAlive()) {
                    if (liveNeighbours < 2) {
                        grid.setCellSurvival(x, y, false);
                    } else if ((liveNeighbours == 2 || liveNeighbours == 3)) {
                        grid.setCellSurvival(x, y, true);
                    } else if (liveNeighbours > 3) {
                        grid.setCellSurvival(x, y, false);
                    }
                } else if (liveNeighbours == 3) {
                    grid.setCellSurvival(x, y, true);
                }

                /*if (liveNeighbours == 3) {
                    grid.setCellSurvival(i, j, true);
                } else if (grid.getCell(i, j).isAlive() && liveNeighbours == 2) {
                    grid.setCellSurvival(i, j, true);
                } else {
                    grid.setCellSurvival(i, j, grid.getCell(i, j).isAlive());
                }*/
            }
        }
    }

    private int numLiveNeighbours(Cell[] neighbours) {
        int liveNeighbours = 0;
        for (Cell neighbour : neighbours) {
            if (neighbour != null && neighbour.isAlive())
                liveNeighbours++;
        }

        return liveNeighbours;
    }
}
