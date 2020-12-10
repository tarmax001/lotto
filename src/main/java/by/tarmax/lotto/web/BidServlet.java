package by.tarmax.lotto.web;

import by.tarmax.lotto.model.Bid;
import by.tarmax.lotto.util.BidUtil;
import by.tarmax.lotto.util.PairUtil;
import by.tarmax.lotto.web.bid.BidRestController;
import org.slf4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

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

    private ConfigurableApplicationContext appCtx;
    private BidRestController controller;

    @Override
    public void init() throws ServletException {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        controller = appCtx.getBean(BidRestController.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action == null ? "all" : action) {
            case "delete":
                controller.delete(getId(req));
                resp.sendRedirect("bids");
                break;
            case "create":
            case "update":
                Bid bid = "update".equals(action) ? controller.get(getId(req)) :
                        new Bid(LocalDate.now(), LocalDate.now(), 2.0);
                req.setAttribute("bid", bid);
                req.setAttribute("balls", PairUtil.ALL_KENO_BALLS);
                req.getRequestDispatcher("/bidForm.jsp").forward(req, resp);
                break;
            case "all":
            default:
                log.info("Get all bids");
                req.setAttribute("bids", BidUtil.getWithGain(controller.getAll(), BidUtil.kenoPlays));
                req.getRequestDispatcher("/bids.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Bid bid = new Bid(LocalDate.parse(req.getParameter("playDate")),
                LocalDate.parse(req.getParameter("bidDate")),
                Double.parseDouble(req.getParameter("amount")),
                Arrays.stream(req.getParameterValues("balls")).map(Integer::parseInt).collect(Collectors.toSet())
        );
        if (StringUtils.isEmpty(req.getParameter("id"))) {
            controller.create(bid);
        } else {
            controller.update(bid, getId(req));
        }
        resp.sendRedirect("bids");
    }

    private Integer getId(HttpServletRequest req) {
        String paramId = Objects.requireNonNull(req.getParameter("id"));
        return Integer.parseInt(paramId);
    }

    @Override
    public void destroy() {
        appCtx.close();
        super.destroy();
    }
}
