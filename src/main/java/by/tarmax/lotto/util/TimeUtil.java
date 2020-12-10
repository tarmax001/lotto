package by.tarmax.lotto.util;

import java.time.LocalDate;

public class TimeUtil {
    private static final LocalDate MIN_DATE = LocalDate.of(1, 1, 1); //TODO first play date
    private static final LocalDate MAX_DATE = LocalDate.of(2100, 1, 1);

    public static <T extends Comparable<T>> boolean isBetweenHalfOpen(T lt, T start, T end) {
        return lt.compareTo(start) >= 0 && lt.compareTo(end) < 0;
    }

    public static LocalDate valueOrMin(LocalDate localDate) {
        return localDate != null ? localDate : MIN_DATE;
    }

    public static LocalDate valueOrMax(LocalDate localDate) {
        return localDate != null ? localDate : MAX_DATE;
    }
}
