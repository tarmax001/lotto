package by.tarmax.lotto.util;

import by.tarmax.lotto.model.Combination;
import by.tarmax.lotto.model.Keno;
import by.tarmax.lotto.model.Pair;
import by.tarmax.lotto.model.PairData;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PairUtil {
    private static final List<Integer> ALL_KENO_BALLS = IntStream.range(1, 61).boxed().collect(Collectors.toList());

    private PairUtil() {
    }

    public static List<Pair> analyzePairs(List<Keno> list, LocalDate from, LocalDate to, int deep) {

        Map<Combination, PairData> map1 = getPairsWithDates(from, to);
        Map<Combination, PairData> map2 = getPairsWithDates(from.minusDays(deep), to.minusDays(deep));
        Map<Combination, PairData> map3 = getPairsWithDates(from.minusDays(deep * 2), to.minusDays(deep * 2));
        Map<Combination, PairData> map4 = getPairsWithDates(from.minusDays(deep * 3), to.minusDays(deep * 3));
        Map<Combination, PairData> map5 = getPairsWithDates(from.minusDays(deep * 4), to.minusDays(deep * 4));
        Map<Combination, PairData> map6 = getPairsWithDates(from.minusDays(deep * 5), to.minusDays(deep * 5));

        return map1.entrySet().stream()
                .map(e -> new Pair(e.getKey(), e.getValue().getCount(), map2.get(e.getKey()).getCount(), map3.get(e.getKey()).getCount(),
                        map4.get(e.getKey()).getCount(), map5.get(e.getKey()).getCount(), map6.get(e.getKey()).getCount()))
                .sorted()
                .collect(Collectors.toList());
    }

    private static Map<String, Combination> getPairsWithDates(List<Keno> kenoPlays) {
        Map<String, Combination> allPairs = getAllPairsOf(ALL_KENO_BALLS);
        kenoPlays.forEach(keno -> getAllPairsOf(keno.getBalls()).forEach((k, v) -> allPairs.get(k).setDate(keno.getPlayDate())));
        return allPairs;
    }

    private static Map<String, Combination> getAllPairsOf(Collection<Integer> balls) {
        Map<String, Combination> allPairsOfBalls = new HashMap<>();
        List<Integer> sortedBalls = new ArrayList<>(balls).stream()
                .sorted()
                .collect(Collectors.toList());
        for (int i = 1; i < sortedBalls.size(); i++) {
            for (int y = i+1; y <= sortedBalls.size(); y++) {
                Combination combination = new Combination();
                String key = getStringKey(sortedBalls.get(i), sortedBalls.get(y));
                combination.setBall(sortedBalls.get(i));
                combination.setBall(sortedBalls.get(y));
                allPairsOfBalls.put(key, combination);
            }
        }
        return allPairsOfBalls;
    }

    private static String getStringKey(int ballOne, int ballTwo) {
        return String.format("%d%d", ballOne, ballTwo);
    }
}
