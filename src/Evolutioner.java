public class Evolutioner {
    private final Grid grid;

    public Evolutioner(Grid grid) {
        this.grid = grid;
    }

    private void shouldSurvive() {
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                Cell[] neighbours = grid.getNeighbours(i, j);
                int liveNeighbours = numLiveNeighbours(neighbours);

                if (liveNeighbours == 3) {
                    grid.setCellSurvival(i, j, true);
                } else if (grid.getCell(i, j).isAlive() && liveNeighbours == 2) {
                    grid.setCellSurvival(i, j, true);
                } else {
                    grid.setCellSurvival(i, j, grid.getCell(i, j).isAlive());
                }
            }
        }
    }

    private int numLiveNeighbours(Cell[] neighbours) {
        int liveNeighbours = 0;
        for (Cell neighbour : neighbours) {
            if (neighbour.isAlive())
                liveNeighbours++;
        }

        return liveNeighbours;
    }
}
