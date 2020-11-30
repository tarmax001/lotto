package by.tarmax.lotto.model;

import java.time.LocalDate;
import java.util.*;

public class Pair implements Comparable<Pair>{
    private Set<LocalDate> dates;
    private Set<Integer> balls;
    private List<Integer> dropRate;
    private LocalDate lastDate;
    private Integer sum;
    private double constancy;

    public Pair(Set<LocalDate> dates, Set<Integer> balls, List<Integer> dropRate, LocalDate lastDate, Integer sum, double constancy) {
        this.dates = dates;
        this.balls = balls;
        this.dropRate = dropRate;
        this.lastDate = lastDate;
        this.sum = sum;
        this.constancy = constancy;
    }

    public Set<LocalDate> getDates() {
        return dates;
    }

    public void setDates(Set<LocalDate> dates) {
        this.dates = dates;
    }

    public Set<Integer> getBalls() {
        return balls;
    }

    public void setBalls(Set<Integer> balls) {
        this.balls = balls;
    }

    public List<Integer> getDropRate() {
        return dropRate;
    }

    public void setDropRate(List<Integer> dropRate) {
        this.dropRate = dropRate;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public double getConstancy() {
        return constancy;
    }

    public void setConstancy(double constancy) {
        this.constancy = constancy;
    }

    @Override
    public String toString() {
        return
                "combination=" + balls +
                ", " + dropRate +
                ", sum=" + sum +
                ", " + lastDate +
                ", " + constancy +
                '}';
    }

    @Override
    public int compareTo(Pair o) {
//        return this.one - o.getOne();
        int i = 0;
        if (this.constancy > o.getConstancy()) {
            i = 1;
        } else if(this.constancy < o.getConstancy()) {
            i = -1;
        }
        return i;
    }
}
