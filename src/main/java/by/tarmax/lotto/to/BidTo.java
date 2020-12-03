package by.tarmax.lotto.to;

import by.tarmax.lotto.model.Ball;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class BidTo {
    private LocalDate playDate;
    private LocalDate date;
    private Double gain;
    private Double amount;
    private final Set<Ball> balls;

    public BidTo(LocalDate playDate, LocalDate date, Double gain, Double amount, Collection<Ball> balls) {
        this.playDate = playDate;
        this.date = date;
        this.gain = gain;
        this.amount = amount;
        this.balls = new TreeSet<>(balls);
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

    public Double getGain() {
        return gain;
    }

    public void setGain(Double gain) {
        this.gain = gain;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BidTo{" +
                "playDate=" + playDate +
                ", date=" + date +
                ", gain=" + gain +
                ", amount=" + amount +
                ", balls=" + balls +
                '}';
    }
}
