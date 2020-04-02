package uk.co.stevebeard.watchnext.webapp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ItemController {

    private final ItemRepository repository;

    ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/items")
    List<Item> all() {
        return repository.findAll();
    }

    @PostMapping("/items")
    public Item newItem(@RequestBody Item newItem) {
        return repository.save(newItem);
    }

    @GetMapping("/items/{id}")
    ResponseEntity<Item> findById(@PathVariable Long id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/items/random")
    ResponseEntity<Item> random() {
        long count = repository.count();
        int idx = (int) (Math.random() * count);
        Page<Item> page = repository.findAll(PageRequest.of(idx, 1));
        if (page.hasContent()) {
            return ResponseEntity.ok(page.getContent().get(0));
        }
        return ResponseEntity.noContent().build();
    }

}
