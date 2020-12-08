package by.tarmax.lotto.repository;

import by.tarmax.lotto.model.AbstractBaseEntity;
import by.tarmax.lotto.model.User;
import by.tarmax.lotto.util.UserUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        }
        return users.computeIfAbsent(user.getId(), u -> users.put(user.getId(), user));
    }

    @Override
    public boolean delete(int id) {
        return users.remove(id, users.get(id));
    }

    @Override
    public User get(int id) {
        return users.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return users.values().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAll() {
        return List.copyOf(users.values());
    }
}
