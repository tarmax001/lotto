package by.tarmax.lotto.model;

public class Ball implements Comparable{
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
    public int compareTo(Object o) {
        Ball ball = (Ball) o;
        return value - ball.getValue();
    }
}
