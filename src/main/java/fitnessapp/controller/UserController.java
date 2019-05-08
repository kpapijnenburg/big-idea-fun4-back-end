package fitnessapp.controller;

import com.sun.deploy.net.HttpResponse;
import fitnessapp.interfaces.IController;
import fitnessapp.model.User;
import fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
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
    public ResponseEntity save(@RequestBody User user) {
        if (service.save(user)) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody User received, @PathVariable long id) {
        Optional<User> optional = service.getById(id);

        if (optional.isPresent()) {
            User target = optional.get();

            target.setEmail(received.getEmail());
            target.setPassword(received.getPassword());

            if (service.update(target)) {
                return new ResponseEntity(HttpStatus.ACCEPTED);
            }
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        Optional<User> optional = service.getById(id);

        if (optional.isPresent()) {
            User target = optional.get();

            if (service.delete(target)) {
                return new ResponseEntity(HttpStatus.ACCEPTED);
            }
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/getByCredentials", method = RequestMethod.POST)
    public ResponseEntity getByCredentials(@RequestBody User credentials){
        User user = service.getByCredentials(credentials.getEmail(), credentials.getPassword());

        if (user != null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

}
