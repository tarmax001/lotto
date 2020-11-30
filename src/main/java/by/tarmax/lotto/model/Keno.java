package by.tarmax.lotto.model;

import java.time.LocalDate;
import java.util.Set;

public class Keno {
    private int playNumber;
    private LocalDate playDate;
    private Set<Integer> balls;

    public Keno(int playNumber, LocalDate playDate, Set<Integer> balls) {
        this.playNumber = playNumber;
        this.playDate = playDate;
        this.balls = balls;
    }

    public int getPlayNumber() {
        return playNumber;
    }

    public void setPlayNumber(int playNumber) {
        this.playNumber = playNumber;
    }

    public LocalDate getPlayDate() {
        return playDate;
    }

    public void setPlayDate(LocalDate playDate) {
        this.playDate = playDate;
    }

    public Set<Integer> getBalls() {
        return balls;
    }

    public void setBalls(Set<Integer> balls) {
        this.balls = balls;
    }
}
