package by.tarmax.lotto.model;

import java.time.LocalDate;
import java.util.Set;

public class Bid {
    private LocalDate playDate;
    private LocalDate bidDate;
    private Double amount;
    private Set<Integer> balls;

    public Bid(LocalDate playDate, LocalDate bidDate, Double amount, Integer... balls) {
        this.playDate = playDate;
        this.bidDate = bidDate;
        this.amount = amount;
        this.balls = Set.of(balls);
    }

    public LocalDate getPlayDate() {
        return playDate;
    }

    public void setPlayDate(LocalDate playDate) {
        this.playDate = playDate;
    }

    public LocalDate getBidDate() {
        return bidDate;
    }

    public void setBidDate(LocalDate bidDate) {
        this.bidDate = bidDate;
    }

    public Set<Integer> getBalls() {
        return balls;
    }

    public void setBalls(Set<Integer> balls) {
        this.balls = balls;
    }
}
