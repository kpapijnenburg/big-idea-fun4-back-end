package fitnessapp.interfaces;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

    T getById(long id);
    List<T> getAll();
    boolean save( T t);
    boolean update(T t);
    boolean delete(T t);
}
