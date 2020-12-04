package by.tarmax.lotto.web;

import by.tarmax.lotto.util.BidUtil;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class BidServlet extends HttpServlet {
    private static final Logger log = getLogger(BidServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Get all bids");
        req.setAttribute("bids", BidUtil.getWithGain(BidUtil.bids, BidUtil.kenoPlays));
        req.getRequestDispatcher("/bids.jsp").forward(req, resp);
    }
}
