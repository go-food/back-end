package gofood.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T extends BaseEntity> {
    protected BaseService<T> service;

    public BaseController(BaseService<T> service) {
        this.service = service;
    }

    @GetMapping
    public List<T> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public T add(@RequestBody T t) {
        return service.add(t);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable("id") Integer id) {
        return service.deleteById(id);
    }

    @DeleteMapping
    public HttpStatus deleteAll() {
        return service.deleteAll();
    }

    @PatchMapping(value = "/{id}")
    public T updateById(@RequestBody T t, @PathVariable("id") Integer id) {
        return service.updateById(t, id);
    }
}