package by.tarmax.lotto.repository;

import by.tarmax.lotto.SecurityUtil;
import by.tarmax.lotto.model.AbstractBaseEntity;
import by.tarmax.lotto.model.Bid;
import by.tarmax.lotto.util.BidUtil;
import by.tarmax.lotto.web.BidServlet;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

@Repository
public class InMemoryBidRepository implements BidRepository{
    private static final Logger log = getLogger(BidServlet.class);

    Map<Integer, Map<Integer, Bid>> bids = new ConcurrentHashMap<>();

    {
        BidUtil.bids.forEach(bid -> this.save(SecurityUtil.authUserId(), bid));
    }

    @Override
    public Bid save(int userId, Bid bid) { //TODO test and compare
        Map<Integer, Bid> userBids = bids.getOrDefault(userId, new ConcurrentHashMap<>());
        if (bid.isNew()) {
            int id = AbstractBaseEntity.counter.incrementAndGet();
            bid.setId(id);
        }
        userBids.put(bid.getId(), bid);
        bids.put(userId, userBids);
        return bid;
    }

    @Override
    public boolean delete(int userId, int id) {
        Map<Integer, Bid> userBids = bids.get(userId);
        return userBids != null && userBids.remove(id) != null;
    }

    @Override
    public Bid get(int userId, int id) {
        Map<Integer, Bid> userBids = bids.get(userId);
        return userBids != null ? userBids.get(id) : null;
    }

    @Override
    public List<Bid> getAll(int userId) {
        Map<Integer, Bid> userBids = bids.get(userId);
        return userBids != null ? userBids.values().stream()
                .sorted(Comparator.comparing(Bid::getPlayDate))
                .collect(Collectors.toList()) : Collections.emptyList();
    }
}
