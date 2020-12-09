package by.tarmax.lotto.util;

import by.tarmax.lotto.model.Ball;
import by.tarmax.lotto.model.Bid;
import by.tarmax.lotto.model.Keno;
import by.tarmax.lotto.to.BidTo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BidUtil {
    private static final double[][] KenoGainTable = {
            {0, 0, 10},
            {0, 0, 2, 20},
            {0, 0, 0, 6, 56},
            {0, 0, 0, 4, 8, 66},
            {0, 0, 0, 0, 8, 26, 260},
            {0, 0, 0, 0, 4, 8, 44, 1_000},
            {4, 0, 0, 0, 0, 6, 26, 110, 4_000},
            {4, 0, 0, 0, 0, 4, 10, 40, 440, 8_000},
            {10, 0, 0, 0, 0, 2, 4, 20, 100, 1_000, 50_000}
    };

    public static List<Keno> kenoPlays = Arrays.asList(
            new Keno(3954, LocalDate.of(2020, 11, 20), Set.of(27, 43, 51, 17, 58, 21, 41, 60, 49, 50, 23, 8, 36, 48, 15, 30, 45, 29, 7, 57)),
            new Keno(3955, LocalDate.of(2020, 11, 21), Set.of(9, 37, 56, 10, 11, 14, 53, 51, 3, 21, 55, 31, 4, 24, 59, 12, 54, 60, 43, 13)),
            new Keno(3956, LocalDate.of(2020, 11, 22), Set.of(7, 30, 25, 4, 54, 38, 51, 58, 6, 45, 29, 27, 26, 41, 23, 21, 47, 50, 14, 16)),
            new Keno(3957, LocalDate.of(2020, 11, 23), Set.of(19, 30, 58, 44, 23, 29, 22, 3, 46, 57, 17, 24, 12, 48, 54, 45, 55, 16, 6, 13)),
            new Keno(3958, LocalDate.of(2020, 11, 24), Set.of(42, 47, 13, 51, 14, 45, 49, 2, 4, 11, 10, 54, 38, 57, 22, 56, 27, 9, 37, 46))
    );

    public static List<Bid> bids = List.of(
            new Bid(LocalDate.of(2020, 11, 23), LocalDate.of(2020, 11, 22), 2.0, 30, 1),
            new Bid(LocalDate.of(2020, 11, 23), LocalDate.of(2020, 11, 22), 1.0, 1, 58),
            new Bid(LocalDate.of(2020, 11, 23), LocalDate.of(2020, 11, 22), 2.0, 1, 58),
            new Bid(LocalDate.of(2020, 11, 24), LocalDate.of(2020, 11, 22), 1.0, 47, 13),
            new Bid(LocalDate.of(2020, 11, 24), LocalDate.of(2020, 11, 22), 2.0, 30, 58, 55),
            new Bid(LocalDate.of(2020, 11, 24), LocalDate.of(2020, 11, 22), 1.0, 30, 58)
    );

    private BidUtil() {
    }

    public static List<BidTo> getWithGain(Collection<Bid> bids, List<Keno> kenoPlays) {
        List<BidTo> kenoBidTos = new ArrayList<>();
        for (Bid bid : bids) {
            Keno kenoPlay = kenoPlays.stream()
                    .filter(keno -> keno.getPlayDate().isEqual(bid.getPlayDate()))
                    .findFirst()
                    .orElse(null);

            Set<Ball> balls = bid.getBalls().stream()
                    .map(ball -> new Ball(ball, kenoPlay != null && kenoPlay.getBalls().contains(ball)))
                    .collect(Collectors.toSet());

            kenoBidTos.add(new BidTo(bid.getId(), bid.getPlayDate(), bid.getBidDate(), getGain(balls, bid.getAmount()), bid.getAmount(), balls));
        }
        return kenoBidTos;
    }

    private static double getGain(Set<Ball> balls, Double amount) {
        return KenoGainTable[balls.size() - 2][Math.toIntExact(balls.stream().filter(Ball::isVon).count())] / amount.intValue();
    }
}
