package by.tarmax.lotto.repository;

import by.tarmax.lotto.model.Bid;

import java.util.Collection;

public interface BidRepository {
    Bid save(int userId, Bid bid);

    boolean delete(int userId, int id);

    Bid get(int userId, int id);

    Collection<Bid> getAll(int userId);
}
