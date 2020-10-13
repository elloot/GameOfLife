public class Cell {
    private boolean isAlive;
    private boolean willSurvive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void update() {
        isAlive = willSurvive;
    }

    public void setSurvival(boolean willSurvive) {
        this.willSurvive = willSurvive;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "isAlive=" + isAlive +
                ", toDo='" + willSurvive + '\'' +
                '}';
    }
}
