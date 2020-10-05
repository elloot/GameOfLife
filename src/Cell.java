public class Cell {
    private boolean isAlive;
    private boolean toDo;

    public Cell(boolean isAlive, boolean toDo) {
        this.isAlive = isAlive;
        this.toDo = toDo;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void doToDo() {
        isAlive = toDo;
    }

    public boolean getToDo() {
        return toDo;
    }

    public void setToDo(boolean toDo) {
        this.toDo = toDo;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "isAlive=" + isAlive +
                ", toDo='" + toDo + '\'' +
                '}';
    }
}
