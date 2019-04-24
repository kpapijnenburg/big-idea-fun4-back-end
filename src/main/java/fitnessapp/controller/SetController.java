package fitnessapp.controller;

import fitnessapp.interfaces.IController;
import fitnessapp.model.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sets")
public class SetController implements IController<Set> {

    @Override
    public ResponseEntity<Set> getById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Set>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity save(Set set) {
        return null;
    }

    @Override
    public ResponseEntity update(long id) {
        return null;
    }

    @Override
    public ResponseEntity delete(long id) {
        return null;
    }

    public ResponseEntity getByWorkOutId(){
        return null;
    }
}
