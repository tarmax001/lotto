package by.tarmax.lotto;

import by.tarmax.lotto.model.Bid;
import by.tarmax.lotto.model.Combination;
import by.tarmax.lotto.model.Keno;
import by.tarmax.lotto.model.Pair;
import by.tarmax.lotto.to.BidTo;
import by.tarmax.lotto.util.BidUtil;
import by.tarmax.lotto.util.PairUtil;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static List<Keno> kenoPlays = Arrays.asList(
            new Keno(3954, LocalDate.of(2020, 11, 20), Set.of(27, 43, 51, 17, 58, 21, 41, 60, 49, 50, 23, 8, 36, 48, 15, 30, 45, 29, 7, 57)),
            new Keno(3955, LocalDate.of(2020, 11, 21), Set.of(9, 37, 56, 10, 11, 14, 53, 51, 3, 21, 55, 31, 4, 24, 59, 12, 54, 60, 43, 13)),
            new Keno(3956, LocalDate.of(2020, 11, 22), Set.of(7, 30, 25, 4, 54, 38, 51, 58, 6, 45, 29, 27, 26, 41, 23, 21, 47, 50, 14, 16)),
            new Keno(3957, LocalDate.of(2020, 11, 23), Set.of(19, 30, 58, 44, 23, 29, 22, 3, 46, 57, 17, 24, 12, 48, 54, 45, 55, 16, 6, 13)),
            new Keno(3958, LocalDate.of(2020, 11, 24), Set.of(42, 47, 13, 51, 14, 45, 49, 2, 4, 11, 10, 54, 38, 57, 22, 56, 27, 9, 37, 46))
    );

    public static List<Bid> bids = List.of(
            new Bid(LocalDate.of(2020, 11, 23), LocalDate.of(2020, 11, 22), 19, 30, 1),
            new Bid(LocalDate.of(2020, 11, 23), LocalDate.of(2020, 11, 22), 19, 1, 58),
            new Bid(LocalDate.of(2020, 11, 23), LocalDate.of(2020, 11, 22), 44, 1, 58),
            new Bid(LocalDate.of(2020, 11, 24), LocalDate.of(2020, 11, 22), 42, 47, 13),
            new Bid(LocalDate.of(2020, 11, 24), LocalDate.of(2020, 11, 22), 19, 30, 58),
            new Bid(LocalDate.of(2020, 11, 24), LocalDate.of(2020, 11, 22), 2, 30, 58)
    );

    public static void main(String[] args) {
        List<BidTo> withGain = BidUtil.getWithGain(bids);
        withGain.forEach(System.out::println);

        Collection<Combination> pairsWithDates = PairUtil.getPairsWithDates(kenoPlays);
        List<Pair> pairList = PairUtil.analyzePairs(pairsWithDates);
        pairList.forEach(System.out::println);
    }
}
