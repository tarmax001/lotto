package by.tarmax.lotto.web.user;

import by.tarmax.lotto.model.User;
import org.springframework.stereotype.Controller;

import static by.tarmax.lotto.SecurityUtil.authUserId;

@Controller
public class ProfileRestController extends AbstractUserController {

    public User get() {
        return super.get(authUserId());
    }

    public void delete() {
        super.delete(authUserId());
    }

    public void update(User user) {
        super.update(user, authUserId());
    }
}