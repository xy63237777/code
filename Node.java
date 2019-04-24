package day02;

public class Node {
    private int x, y, step,cost;

    public Node() {
    }

    public Node(int x, int y, int step, int cost) {
        this.x = x;
        this.y = y;
        this.step = step;
        this.cost = cost;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
