package by.tarmax.lotto.model;

public class Ball implements Comparable<Ball>{
    private Integer value;
    private boolean isVon;

    public Ball(Integer value, boolean isVon) {
        this.value = value;
        this.isVon = isVon;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isVon() {
        return isVon;
    }

    public void setVon(boolean von) {
        isVon = von;
    }

    @Override
    public int compareTo(Ball ball) {
        return value - ball.getValue();
    }

    @Override
    public String toString() {
        return "Ball{ " + value +
                ", isVon=" + isVon +
                '}';
    }
}
