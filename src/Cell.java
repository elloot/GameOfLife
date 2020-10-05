public class Cell {
    private boolean isAlive;
    private String toDo;

    public Cell(boolean isAlive, String toDo) {
        this.isAlive = isAlive;
        this.toDo = toDo;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
}
