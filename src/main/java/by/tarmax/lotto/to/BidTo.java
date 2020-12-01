package by.tarmax.lotto.to;

import by.tarmax.lotto.model.Ball;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class BidTo {
    private LocalDate playDate;
    private LocalDate date;
    private Integer gain;
    private Set<Ball> balls;

    public BidTo(LocalDate playDate, LocalDate date, Integer gain, Ball... balls) {
        this.playDate = playDate;
        this.date = date;
        this.balls = new TreeSet<>(Arrays.asList(balls));
        this.gain = gain;
    }

    public LocalDate getPlayDate() {
        return playDate;
    }

    public void setPlayDate(LocalDate playDate) {
        this.playDate = playDate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Ball> getBalls() {
        return balls;
    }

    public void setBalls(Set<Ball> balls) {
        this.balls = balls;
    }

    public Integer getGain() {
        return gain;
    }

    public void setGain(Integer gain) {
        this.gain = gain;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "playDate=" + playDate +
                ", date=" + date +
                ", gain=" + gain +
                ", balls=" + balls +
                '}';
    }
}
