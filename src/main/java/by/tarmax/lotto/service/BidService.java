package by.tarmax.lotto.service;

import by.tarmax.lotto.model.Bid;
import by.tarmax.lotto.repository.BidRepository;
import by.tarmax.lotto.util.TimeUtil;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static by.tarmax.lotto.util.ValidationUtil.checkNotFoundWithId;

@Service
public class BidService {

    private final BidRepository repository;

    public BidService(BidRepository repository) {
        this.repository = repository;
    }

    public Bid create(int userId, Bid bid) {
        return repository.save(userId, bid);
    }

    public void delete(int userId, int id) {
        checkNotFoundWithId(repository.delete(userId, id), id);
    }

    public Bid get(int userId, int id) {
        return checkNotFoundWithId(repository.get(userId, id), id);
    }

    public List<Bid> getAll(int userId) {
        return List.copyOf(repository.getAll(userId));
    }

    public void update(int userId, Bid Bid) {
        checkNotFoundWithId(repository.save(userId, Bid), Bid.getId());
    }

    public List<Bid> getBetweenPlayDate(int userId, @Nullable LocalDate start, @Nullable LocalDate end) {
        return repository.getBetweenPlayDates(userId, TimeUtil.valueOrMin(start), TimeUtil.valueOrMax(end));
    }
}
