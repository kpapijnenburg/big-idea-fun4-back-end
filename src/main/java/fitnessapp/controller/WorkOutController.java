package fitnessapp.controller;

import fitnessapp.interfaces.IController;
import fitnessapp.model.WorkOut;
import fitnessapp.service.WorkOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
@CrossOrigin
public class WorkOutController implements IController<WorkOut> {

    private WorkOutService service;

    @Autowired
    public WorkOutController(WorkOutService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<WorkOut> getById(@PathVariable long id) {
        WorkOut workOut = service.getById(id);

        if (workOut != null) {
            return ResponseEntity.ok(workOut);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<WorkOut>> getAll() {
        List<WorkOut> workOuts = service.getAll();

        if (workOuts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(workOuts);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody WorkOut workOut) {
        if (service.save(workOut)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody WorkOut received, @PathVariable long id) {
        WorkOut workOut = service.getById(id);

        if (workOut != null) {

            workOut.setName(received.getName());
            workOut.setDate(received.getDate());
            workOut.setSets(received.getSets());

            if (service.update(workOut)) {
                return ResponseEntity.accepted().build();
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        WorkOut workOut = service.getById(id);

        if (workOut != null) {
            if (service.delete(workOut)) {
                return ResponseEntity.accepted().build();
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/getByUserId/{id}")
    public ResponseEntity getByUserId(@PathVariable Long id) {
        List<WorkOut> workOuts = service.getByUserId(id);

        if (workOuts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(workOuts);
    }

}
