package gofood.city;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CityService extends BaseService<City> {
    @Autowired
    protected CityService(CityRepository repo) {
        super(repo);
    }
}
