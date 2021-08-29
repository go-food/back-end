package gofood.restaurant;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RestaurantService extends BaseService<Restaurant> {
    @Autowired
    protected RestaurantService(RestaurantRepository repo) {
        super(repo);
    }
}
