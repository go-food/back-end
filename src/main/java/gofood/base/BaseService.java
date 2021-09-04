package gofood.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity> {

    protected JpaRepository<T, Integer> repo;

    protected BaseService(JpaRepository<T, Integer> repo) {
        this.repo = repo;
    }

    public List<T> getAll() {
        return repo.findAll();
    }

    @Transactional
    public T add(T t) {
        return repo.save(t);
    }

    @Transactional
    public T getById(Integer id) {
        Optional<T> t = repo.findById(id);
        if (t.isEmpty()) return null;
        return t.get();
    }

    @Transactional
    public HttpStatus deleteById(Integer id) {
        try {
            repo.deleteById(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

//    @Transactional
//    public HttpStatus deleteAll() {
//        try {
//            repo.deleteAll();
//            return HttpStatus.OK;
//        } catch (Exception e) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//    }

    @Transactional
    public T updateById(T t, Integer id) {
        return null;
    }
}