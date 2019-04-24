package fitnessapp.controller;

import fitnessapp.interfaces.IController;
import fitnessapp.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements IController<User> {

    public ResponseEntity<User> getById(long id) {
        return null;
    }

    public ResponseEntity<List<User>> getAll() {
        return null;
    }

    public ResponseEntity save(User user) {
        return null;
    }

    public ResponseEntity update(User user) {
        return null;
    }

    public ResponseEntity delete(User user) {
        return null;
    }
}
