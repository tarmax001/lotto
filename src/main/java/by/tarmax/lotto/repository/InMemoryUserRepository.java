package by.tarmax.lotto.repository;

import by.tarmax.lotto.model.AbstractBaseEntity;
import by.tarmax.lotto.model.User;
import by.tarmax.lotto.util.UserUtil;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository implements UserRepository{
    Map<Integer, User> users = new ConcurrentHashMap<>();

    {
        UserUtil.users.forEach(this::save);
    }

    @Override
    public User save(User user) {
        if (user.isNew()) {
            int id = AbstractBaseEntity.counter.incrementAndGet();
            user.setId(id);
            users.put(id, user);
            return user;
        }
        return users.computeIfPresent(user.getId(), (id, oldUser) -> user);
    }

    @Override
    public boolean delete(int id) {
        return users.remove(id) != null;
    }

    @Override
    public User get(int id) {
        return users.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return users.values().stream()
                .filter(user -> email.equalsIgnoreCase(user.getEmail()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAll() {
        return users.values().stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getEmail))
                .collect(Collectors.toList());
    }
}
