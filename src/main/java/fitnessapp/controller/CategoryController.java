package fitnessapp.controller;

import fitnessapp.interfaces.IController;
import fitnessapp.model.Category;
import fitnessapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController implements IController<Category> {

    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getById(@PathVariable long id) {
        Optional<Category> category = service.getById(id);

        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = service.getAll();

        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(Category category) {
        if (service.save(category)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Category received, @PathVariable long id) {
        Optional<Category> optional = service.getById(id);

        if (optional.isPresent()) {
            Category target = optional.get();

            target.setName(received.getName());

            if (service.update(target)) {
                return ResponseEntity.accepted().build();
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @RequestMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Optional<Category> category = service.getById(id);

        if (category.isPresent()) {

            if (service.delete(category.get())) {
                return ResponseEntity.accepted().build();
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
