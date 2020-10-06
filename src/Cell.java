public class Cell {
    private boolean isAlive;
    private boolean willSurvive;

    public Cell(boolean isAlive, boolean willSurvive) {
        this.isAlive = isAlive;
        this.willSurvive = willSurvive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void execSurvival() {
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
