package by.tarmax.lotto.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Bid extends AbstractBaseEntity {
    private LocalDate playDate;
    private LocalDate bidDate;
    private Double amount;
    private Set<Integer> balls;

    public Bid(LocalDate playDate, LocalDate bidDate, Double amount, Integer... balls) {
        this(null, playDate, bidDate, amount, Set.of(balls));
    }

    public Bid(LocalDate playDate, LocalDate bidDate, Double amount, Set<Integer> balls) {
        this(null, playDate, bidDate, amount, balls);
    }

    public Bid(Integer id, LocalDate playDate, LocalDate bidDate, Double amount, Set<Integer> balls) {
        super(id);
        this.playDate = playDate;
        this.bidDate = bidDate;
        this.amount = amount;
        this.balls = balls;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +

                ", playDate=" + playDate +
                ", bidDate=" + bidDate +
                ", amount=" + amount +
                ", balls=" + balls +
                '}';
    }
}
