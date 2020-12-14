package by.tarmax.lotto;

public class SecurityUtil {
    private static Integer userId;

    public static int authUserId() {
        return userId;
    }

    public static void setUserId(Integer id) {
        userId = id;
    }
}