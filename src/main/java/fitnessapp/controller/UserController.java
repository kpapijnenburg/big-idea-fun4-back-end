package fitnessapp.controller;

import fitnessapp.interfaces.IController;
import fitnessapp.model.User;
import fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController implements IController<User> {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getById(@PathVariable long id) {
        Optional<User> user = service.getById(id);

        //noinspection OptionalIsPresent
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll() {
        List<User> users = service.getAll();

        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(User user) {
        if (service.save(user)) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable long id) {
        Optional<User> user = service.getById(id);

        if (user.isPresent()) {
            if (service.update(user.get())) {
                return new ResponseEntity(HttpStatus.ACCEPTED);
            }
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        Optional<User> user = service.getById(id);

        if (user.isPresent()) {
            if (service.delete(user.get())) {
                return new ResponseEntity(HttpStatus.ACCEPTED);
            }

            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
