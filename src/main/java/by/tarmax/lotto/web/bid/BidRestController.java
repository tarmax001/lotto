package by.tarmax.lotto.web.bid;

import by.tarmax.lotto.SecurityUtil;
import by.tarmax.lotto.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import by.tarmax.lotto.model.Bid;
import by.tarmax.lotto.service.BidService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BidRestController {
    private static final Logger log = LoggerFactory.getLogger(BidRestController.class);

    private final BidService bidService;

    public BidRestController(BidService bidService) {
        this.bidService = bidService;
    }

    public Bid create(Bid bid) {
        int userId = SecurityUtil.authUserId();
        ValidationUtil.checkNew(bid);
        log.info("Create bid {} for user {}", bid, userId);
        return bidService.create(userId, bid);
    }

    public void update(Bid bid, int id) {
        int userId = SecurityUtil.authUserId();
        ValidationUtil.assureIdConsistent(bid, id);
        log.info("Update bid {} for user {}", bid, userId);
        bidService.update(userId, bid);
    }

    public void delete(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("Delete bid with id {} for user {}", id, userId);
        bidService.delete(userId, id);
    }

    public Bid get(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("Get bid with id {} for user {}", id, userId);
        return bidService.get(userId, id);
    }

    public List<Bid> getAll() {
        int userId = SecurityUtil.authUserId();
        log.info("Get all bids for user {}", userId);
        return bidService.getAll(userId);
    }

    public List<Bid> getBetween(@Nullable LocalDate start, @Nullable LocalDate end) {
        int userId = SecurityUtil.authUserId();
        log.info("Get filtered from {} to {} bids for user {}",start, end, userId);
        return bidService.getBetweenPlayDate(userId, start, end);
    }
 }
