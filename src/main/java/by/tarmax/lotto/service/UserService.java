package by.tarmax.lotto.service;

import by.tarmax.lotto.model.User;
import by.tarmax.lotto.repository.UserRepository;

import java.util.List;

import static by.tarmax.lotto.util.ValidationUtil.checkNotFound;
import static by.tarmax.lotto.util.ValidationUtil.checkNotFoundWithId;

public class UserService {

    private UserRepository repository;

    public User create(User user) {
        return repository.save(user);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public User get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public User getByEmail(String email) {
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public void update(User user) {
        checkNotFoundWithId(repository.save(user), user.getId());
    }
}