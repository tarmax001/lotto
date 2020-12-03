package by.tarmax.lotto.util;

import by.tarmax.lotto.model.Ball;
import by.tarmax.lotto.model.Bid;
import by.tarmax.lotto.model.Keno;
import by.tarmax.lotto.to.BidTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    private BidUtil() {
    }

    public static List<BidTo> getWithGain(List<Bid> bids, List<Keno> kenoPlays) {
        List<BidTo> kenoBidTos = new ArrayList<>();
        for (Bid bid : bids) {
            Keno kenoPlay = kenoPlays.stream()
                    .filter(keno -> keno.getPlayDate().isEqual(bid.getPlayDate()))
                    .findFirst()
                    .orElse(null);

            Set<Ball> balls = bid.getBalls().stream()
                    .map(ball -> new Ball(ball, kenoPlay != null && kenoPlay.getBalls().contains(ball)))
                    .collect(Collectors.toSet());

            kenoBidTos.add(new BidTo(bid.getPlayDate(), bid.getBidDate(), getGain(balls, bid.getAmount()), bid.getAmount(), balls));
        }
        return kenoBidTos;
    }

    private static double getGain(Set<Ball> balls, Double amount) {
        return KenoGainTable[balls.size() - 2][Math.toIntExact(balls.stream().filter(Ball::isVon).count())]/amount.intValue();
    }
}
