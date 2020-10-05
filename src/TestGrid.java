public class TestGrid {
    public static void main(String[] args) {
        Grid grid = new Grid(20, 20, 0.6);
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                System.out.print((grid.getCell(i* grid.getWidth() + j).isAlive() ? "\u25A1" : "\u25A0") + " ");
            }
            System.out.println();
        }
    }
}
