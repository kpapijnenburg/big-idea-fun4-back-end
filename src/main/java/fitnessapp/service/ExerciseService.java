package fitnessapp.service;

import fitnessapp.interfaces.IService;
import fitnessapp.model.Exercise;

import java.util.List;
import java.util.Optional;

public class ExerciseService implements IService {
    @Override
    public Optional getById(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public boolean save(Object o) {
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    public List<Exercise> getBySetId(long id){
        return null;
    }
}
