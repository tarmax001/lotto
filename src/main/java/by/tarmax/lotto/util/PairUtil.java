package by.tarmax.lotto.util;

import by.tarmax.lotto.model.Combination;
import by.tarmax.lotto.model.Keno;
import by.tarmax.lotto.model.Pair;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PairUtil {
    public static final List<Integer> ALL_KENO_BALLS = IntStream.range(1, 61).boxed().collect(Collectors.toList());
    public static LocalDate currentDate = LocalDate.now().minusDays(1);
    public static int step = 30;
    public static int period = 180;

    private PairUtil() {
    }

    public static List<Pair> analyzePairs(Collection<Combination> combinations) {
        return combinations.stream()
                .map(PairUtil::covertToPair)
                .collect(Collectors.toList());
    }

    public static Collection<Combination> getPairsWithDates(List<Keno> kenoPlays) {
        Map<String, Combination> allPairs = getAllPairsOf(ALL_KENO_BALLS);
        LocalDate from = LocalDate.now().minusDays(period);
        LocalDate to = LocalDate.now().minusDays(1);
        kenoPlays.stream()
                .filter(keno -> TimeUtil.isBetweenHalfOpen(keno.getPlayDate(), from, to))
                .forEach(keno -> getAllPairsOf(keno.getBalls()).forEach((k, v) -> allPairs.get(k).setDate(keno.getPlayDate())));
        return allPairs.values();
    }

    private static Pair covertToPair(Combination combination) {
        Set<LocalDate> dates = combination.getDates();
        List<Integer> dropRateWithStep = new ArrayList<>();
        int cursor = 0;
        int rest = period;
        while (rest > 0) {
            int finalCursor = cursor;
            dropRateWithStep.add(Math.toIntExact(dates.stream()
                    .filter(ld -> TimeUtil.isBetweenHalfOpen(ld, currentDate.minusDays(step), currentDate.minusDays(finalCursor)))
                    .count()));
            cursor += step;
            rest -= step;
        }

        LocalDate lastDate = combination.getDates().stream()
                .max(LocalDate::compareTo)
                .orElse(null);

        int sum = combination.getDates().size();

        double constancy = 0.0;
        if (!dropRateWithStep.isEmpty()) {
            double avr = sum != 0 ? sum / dropRateWithStep.size() : 0.0;
            constancy = dropRateWithStep.stream()
                    .mapToDouble(i -> Math.abs(i - avr))
                    .sum() / dropRateWithStep.size();
        }

        return new Pair(combination.getDates(), combination.getSet(), dropRateWithStep, lastDate, sum, constancy);
    }

    private static Map<String, Combination> getAllPairsOf(Collection<Integer> balls) {
        Map<String, Combination> allPairsOfBalls = new HashMap<>();
        List<Integer> sortedBalls = new ArrayList<>(balls).stream()
                .sorted()
                .collect(Collectors.toList());
        for (int i = 0; i < sortedBalls.size() - 2; i++) {
            for (int y = i + 1; y <= sortedBalls.size() - 1; y++) {
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
        return String.format("%02d%d", ballOne, ballTwo);
    }
}
