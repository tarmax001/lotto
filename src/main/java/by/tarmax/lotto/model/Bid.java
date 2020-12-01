package by.tarmax.lotto.model;

import java.time.LocalDate;
import java.util.Set;

public class Bid {
    private LocalDate playDate;
    private LocalDate bidDate;
    private Set<Integer> balls;

    public Bid(LocalDate playDate, LocalDate bidDate, Integer... balls) {
        this.playDate = playDate;
        this.bidDate = bidDate;
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
