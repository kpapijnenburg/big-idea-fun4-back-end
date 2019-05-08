package fitnessapp.controller;

import fitnessapp.interfaces.IController;
import fitnessapp.model.Exercise;
import fitnessapp.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercises")
@CrossOrigin
public class ExerciseController implements IController<Exercise> {

    private ExerciseService service;

    @Autowired
    public ExerciseController(ExerciseService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Exercise> getById(@PathVariable long id) {
        Optional<Exercise> exercise = service.getById(id);

        if (exercise.isPresent()) {
            return ResponseEntity.ok(exercise.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Exercise>> getAll() {
        List<Exercise> exercises = service.getAll();

        if (exercises.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(exercises);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(Exercise exercise) {
        if (service.save(exercise)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Exercise received, @PathVariable long id) {
        Optional<Exercise> target = service.getById(id);

        if (target.isPresent()) {
            Exercise exercise = target.get();

            exercise.setName(received.getName());

            if (service.update(exercise)) {
                return ResponseEntity.accepted().build();
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        Optional<Exercise> exercise = service.getById(id);

        if (exercise.isPresent()) {
            if (service.delete(exercise.get())) {
                return ResponseEntity.accepted().build();
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/getBySetId/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Exercise>> getBySetId(@PathVariable long id) {
        List<Exercise> exercises = service.getBySetId(id);

        if (exercises.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(exercises);
    }

    @RequestMapping(value = "getByCategoryId/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Exercise>> getByCategoryId(@PathVariable long id) {
        List<Exercise> exercises = service.getByCategoryId(id);

        if (exercises.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(exercises);
    }
}
