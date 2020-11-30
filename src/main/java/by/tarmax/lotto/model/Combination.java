package by.tarmax.lotto.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Combination {
    private Set<LocalDate> dates = new HashSet<>();
    Set<Integer> set = new TreeSet<>();

    public Combination() {
    }

    public Combination(Integer id, LocalDate date, TreeSet<Integer> set) {
        this.set = set;
    }

    public void setDate(LocalDate date) {
        dates.add(date);
    }

    public void setBall(Integer ball) {
        set.add(ball);
    }

    public void setSet(Set<Integer> set) {
        this.set = set;
    }

    public Set<Integer> getSet() {
        return set;
    }

    public LocalDate getLastDate() {
        return dates.stream()
                .reduce((first, second) -> second)
                .orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Combination couple = (Combination) o;

        return set != null ? set.equals(couple.set) : couple.set == null;
    }

    @Override
    public int hashCode() {
        return set != null ? set.hashCode() : 0;
    }

    @Override
    public String toString() {
        return set.toString();
//        return
//                "Combination{" +
//                "date=" + date +
//                ", set=" + set +
//                '}';
    }
}
