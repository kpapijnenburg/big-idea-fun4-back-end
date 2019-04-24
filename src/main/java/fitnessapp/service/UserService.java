package fitnessapp.service;

import fitnessapp.interfaces.IService;
import fitnessapp.model.User;

import java.util.List;
import java.util.Optional;

public class UserService implements IService<User> {

    @Override
    public Optional<User> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }
}
