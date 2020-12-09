package by.tarmax.lotto.repository;

import by.tarmax.lotto.model.Bid;

import java.util.Collection;
import java.util.List;

public interface BidRepository {
    Bid save(int userId, Bid bid);

    boolean delete(int userId, int id);

    Bid get(int userId, int id);

    List<Bid> getAll(int userId);
}
