package fitnessapp.service;

import fitnessapp.interfaces.IService;
import fitnessapp.model.Set;
import fitnessapp.model.WorkOut;

import java.util.List;
import java.util.Optional;

public class SetService implements IService<Set> {


    @Override
    public Optional<Set> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Set> getAll() {
        return null;
    }

    @Override
    public boolean save(Set set) {
        return false;
    }

    @Override
    public boolean update(Set set) {
        return false;
    }

    @Override
    public boolean delete(Set set) {
        return false;
    }

    public List<WorkOut> getByWorkOutId(long id) {
        return null;
    }
}
