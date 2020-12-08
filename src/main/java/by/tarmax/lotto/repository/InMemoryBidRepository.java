package by.tarmax.lotto.repository;

import by.tarmax.lotto.SecurityUtil;
import by.tarmax.lotto.model.AbstractBaseEntity;
import by.tarmax.lotto.model.Bid;
import by.tarmax.lotto.util.BidUtil;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBidRepository implements BidRepository{
    Map<Integer, Map<Integer, Bid>> bids = new ConcurrentHashMap<>();

    {
        BidUtil.bids.forEach(bid -> this.save(SecurityUtil.authUserId(), bid));
    }

    @Override
    public Bid save(int userId, Bid bid) {
        Map<Integer, Bid> userBids = bids.getOrDefault(userId, new HashMap<>());
        if (bid.isNew()) {
            int id = AbstractBaseEntity.counter.incrementAndGet();
            bid.setId(id);
        }
        userBids.computeIfAbsent(bid.getId(), b -> userBids.put(bid.getId(), bid));
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
    public Collection<Bid> getAll(int userId) {
        Map<Integer, Bid> userBids = bids.get(userId);
        return userBids != null ? userBids.values() : Collections.EMPTY_LIST;
    }
}
