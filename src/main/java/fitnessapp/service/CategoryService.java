package fitnessapp.service;

import fitnessapp.interfaces.IService;
import fitnessapp.model.Category;

import java.util.List;

public class CategoryService implements IService<Category> {
    @Override
    public Category getById(long id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public boolean save(Category category) {
        return false;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean delete(Category category) {
        return false;
    }

}
