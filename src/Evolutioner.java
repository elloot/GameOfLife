public class Evolutioner {
    private final Grid grid;

    public Evolutioner(Grid grid) {
        this.grid = grid;
    }

    public void step() {
        shouldSurvive();
        updateCells();
    }

    private void updateCells() {
        grid.updateCells();
    }

    private void shouldSurvive() {
        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                Cell currentCell = grid.getCell(x, y);
                Cell[] neighbours = grid.getCellNeighbours(x, y);
                int liveNeighbours = countLiveNeighbours(neighbours);

                // rules for deciding a cells survival
                if (currentCell.isAlive()) {
                    if (liveNeighbours < 2) {
                        grid.setCellSurvival(x, y, false);
                    } else grid.setCellSurvival(x, y, liveNeighbours == 2 || liveNeighbours == 3);
                } else if (liveNeighbours == 3) {
                    grid.setCellSurvival(x, y, true);
                }
            }
        }
    }

    private int countLiveNeighbours(Cell[] neighbours) {
        int liveNeighbours = 0;
        for (Cell neighbour : neighbours) {
            if (neighbour != null && neighbour.isAlive())
                liveNeighbours++;
        }

        return liveNeighbours;
    }
}
