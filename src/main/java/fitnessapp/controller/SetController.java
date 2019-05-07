package fitnessapp.controller;

import fitnessapp.interfaces.IController;
import fitnessapp.model.Set;
import fitnessapp.model.WorkOut;
import fitnessapp.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sets")
public class SetController implements IController<Set> {

    private SetService service;

    @Autowired
    public SetController(SetService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Set> getById(@PathVariable long id) {
        Optional<Set> set = service.getById(id);

        if (set.isPresent()) {
            return ResponseEntity.ok(set.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Set>> getAll() {
        List<Set> sets = service.getAll();

        if (sets.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sets);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(Set set) {
        if (service.save(set)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Set received, @PathVariable long id) {
        Optional<Set> optional = service.getById(id);

        if (optional.isPresent()) {
            Set set = optional.get();

            set.setExercise(received.getExercise());
            set.setReps(received.getReps());
            set.setWeight(received.getWeight());

            if (service.update(set)) {
                return ResponseEntity.accepted().build();
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        Optional<Set> set = service.getById(id);

        if (set.isPresent()) {
            if (service.delete(set.get())) {
                return ResponseEntity.accepted().build();
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping("/getByWorkOutId/{id}")
    public ResponseEntity<List<WorkOut>> getByWorkOutId(@PathVariable long id) {
        List<WorkOut> workOuts = service.getByWorkOutId(id);

        if (workOuts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(workOuts);
    }
}
