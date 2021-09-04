package gofood.restaurant;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RestaurantService extends BaseService<Restaurant> {
    RestaurantRepository restaurantRepository;

    @Autowired
    protected RestaurantService(RestaurantRepository repo) {
        super(repo);
        this.restaurantRepository = repo;
    }

    public List<Restaurant> findRestaurant(String name) {
        return restaurantRepository.findAllByNameContains(name);
    }
}
