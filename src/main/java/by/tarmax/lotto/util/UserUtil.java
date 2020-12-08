package by.tarmax.lotto.util;

import by.tarmax.lotto.model.Role;
import by.tarmax.lotto.model.User;

import java.util.Arrays;
import java.util.List;

public class UserUtil {
    public static List<User> users = Arrays.asList(
            new User(10000, "admin@gmail.com", "Admin", "nimda", Role.ADMIN),
            new User(10001, "user@gmail.com", "User", "123456", Role.ADMIN)
    );
}
