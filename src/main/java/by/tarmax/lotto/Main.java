package by.tarmax.lotto;

import by.tarmax.lotto.model.Keno;
import by.tarmax.lotto.model.Pair;
import by.tarmax.lotto.util.PairUtil;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static List<Keno> kenoPlays = Arrays.asList(
            new Keno(3954, LocalDate.of(2020, 11, 20), Set.of(27, 43, 51, 17, 58, 21, 41, 60, 49, 50, 23, 8, 36, 48, 15, 30, 45, 29, 7, 57)),
            new Keno(3955, LocalDate.of(2020, 11, 21), Set.of(9, 37, 56, 10, 11, 14, 53, 51, 3, 21, 55, 31, 4, 24, 59, 12, 54, 60, 43, 13)),
            new Keno(3956, LocalDate.of(2020, 11, 22), Set.of(7, 30, 25, 4, 54, 38, 51, 58, 6, 45, 29, 27, 26, 41, 23, 21, 47, 50, 14, 16)),
            new Keno(3957, LocalDate.of(2020, 11, 23), Set.of(19, 30, 58, 44, 23, 29, 22, 3, 46, 57, 17, 24, 12, 48, 54, 45, 55, 16, 6, 13)),
            new Keno(3958, LocalDate.of(2020, 11, 24), Set.of(42, 47, 13, 51, 14, 45, 49, 2, 4, 11, 10, 54, 38, 57, 22, 56, 27, 9, 37, 46))
    );
    public static void main(String[] args) {
        int minusDay = 1;
        int minusMonth = 1;
        List<Pair> pairList = PairUtil.analyzePairs(kenoPlays, LocalDate.now().minusMonths(minusMonth).minusDays(minusDay), LocalDate.now().minusDays(minusDay), 30);
        pairList.forEach(System.out::println);
    }
}