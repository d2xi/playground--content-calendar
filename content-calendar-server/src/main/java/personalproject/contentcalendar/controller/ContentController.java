package personalproject.contentcalendar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import personalproject.contentcalendar.model.Content;
import personalproject.contentcalendar.repository.ContentCollectionRepository;

// accept request and give a response
@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    private final ContentCollectionRepository repository; // dependency

    // @Autowired is optional with single constructor
    public ContentController(ContentCollectionRepository repository) {
        // repository = new ContentCollectionRepository();
        // the relevant class is annotated - managed by spring framework
        // we only need to get it from the context
        this.repository = repository;
    }

    @GetMapping("") // request on the path itself
    public List<Content> findAll() {
        return repository.findAll(); // injected object
    }

    @GetMapping("/{id}") // request on the path itself
    public Content finbById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found")); // injected
                                                                                                            // object
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Content content) {
        repository.save(content);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Content content) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content with id ${id} not found!");
        } else {
            repository.save(content);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content with id ${id} not found!");
        } else {
            repository.delete(id);
        }
    }

}
