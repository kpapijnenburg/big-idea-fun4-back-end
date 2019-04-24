package fitnessapp.service;

import fitnessapp.interfaces.IService;
import fitnessapp.model.WorkOut;

import java.util.List;
import java.util.Optional;

public class WorkOutService implements IService<WorkOut> {

    @Override
    public Optional<WorkOut> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<WorkOut> getAll() {
        return null;
    }

    @Override
    public boolean save(WorkOut workOut) {
        return false;
    }

    @Override
    public boolean update(WorkOut workOut) {
        return false;
    }

    @Override
    public boolean delete(WorkOut workOut) {
        return false;
    }

    public List<WorkOut> getByUserId(long id) {
        return null;
    }
}
