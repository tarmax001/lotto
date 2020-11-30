package by.tarmax.lotto.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Combination {
    private final Set<LocalDate> dates = new HashSet<>();
    private Set<Integer> set = new TreeSet<>();

    public Combination() {
    }

    public Set<LocalDate> getDates() {
        return dates;
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

        Combination combination = (Combination) o;

        return Objects.equals(set, combination.set);
    }

    @Override
    public int hashCode() {
        return set != null ? set.hashCode() : 0;
    }
}
