package by.tarmax.lotto.web;

import by.tarmax.lotto.model.Combination;
import by.tarmax.lotto.model.Pair;
import by.tarmax.lotto.util.BidUtil;
import by.tarmax.lotto.util.PairUtil;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class PairServlet extends HttpServlet {
    private static final Logger log = getLogger(PairServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Get all pairs");
        Collection<Combination> pairsWithDates = PairUtil.getPairsWithDates(BidUtil.kenoPlays);
        List<Pair> pairList = PairUtil.analyzePairs(pairsWithDates);
        req.setAttribute("pairs", pairList);
        req.getRequestDispatcher("/pairs.jsp").forward(req, resp);
    }
}
