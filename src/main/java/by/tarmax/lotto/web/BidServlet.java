package by.tarmax.lotto.web;

import by.tarmax.lotto.SecurityUtil;
import by.tarmax.lotto.model.Bid;
import by.tarmax.lotto.repository.BidRepository;
import by.tarmax.lotto.repository.InMemoryBidRepository;
import by.tarmax.lotto.util.BidUtil;
import by.tarmax.lotto.util.PairUtil;
import org.slf4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

public class BidServlet extends HttpServlet {
    private static final Logger log = getLogger(BidServlet.class);

    private BidRepository bidRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        bidRepository = new InMemoryBidRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action == null ? "all" : action) {
            case "delete":
                bidRepository.delete(SecurityUtil.authUserId(), getId(req));
                resp.sendRedirect("bids");
                break;
            case "create":
            case "update":
                Bid bid = "update".equals(action) ? bidRepository.get(SecurityUtil.authUserId(), getId(req)) :
                        new Bid(LocalDate.now(), LocalDate.now(), 2.0);
                req.setAttribute("bid", bid);
                req.setAttribute("balls", PairUtil.ALL_KENO_BALLS);
                req.getRequestDispatcher("/bidForm.jsp").forward(req, resp);
                break;
            case "all":
            default:
                log.info("Get all bids");
                req.setAttribute("bids", BidUtil.getWithGain(bidRepository.getAll(SecurityUtil.authUserId()), BidUtil.kenoPlays));
                req.getRequestDispatcher("/bids.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Bid bid = new Bid(id.isEmpty() ? null : Integer.parseInt(id),
                LocalDate.parse(req.getParameter("playDate")),
                LocalDate.parse(req.getParameter("bidDate")),
                Double.parseDouble(req.getParameter("amount")),
                Arrays.stream(req.getParameterValues("balls")).map(Integer::parseInt).collect(Collectors.toSet())
        );
        bidRepository.save(SecurityUtil.authUserId(), bid);
        resp.sendRedirect("bids");
    }

    private Integer getId(HttpServletRequest req) {
        String paramId = Objects.requireNonNull(req.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
