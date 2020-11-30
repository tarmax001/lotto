package by.tarmax.lotto.model;

import java.time.LocalDate;

public class PairData {
    private Integer count = 0;
    private LocalDate lastDate = LocalDate.of(2010, 1, 24);

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "PairData{" +
                "count=" + count +
                ", lastDate=" + lastDate +
                '}';
    }
}
