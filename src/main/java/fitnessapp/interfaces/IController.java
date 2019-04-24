package fitnessapp.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IController<T> {

    ResponseEntity<T> getById (long id);
    ResponseEntity<List<T>> getAll();
    ResponseEntity save(T t);
    ResponseEntity update(T t);
    ResponseEntity delete(T t);
}
