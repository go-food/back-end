package gofood.restaurant;

import gofood.base.BaseService;
import gofood.menu.Menu;
import gofood.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RestaurantService extends BaseService<Restaurant> {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    @Autowired
    protected RestaurantService(RestaurantRepository repo, MenuRepository menuRepository) {
        super(repo);
        this.restaurantRepository = repo;
        this.menuRepository = menuRepository;
    }

    public List<Restaurant> findRestaurantByName(String name) {
        return restaurantRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Menu addMenuToRestaurant(Integer restaurantId, Menu menu) {
        Restaurant restaurant = repo.findById(restaurantId).get();
        menu.setRestaurant(restaurant);
        return menuRepository.save(menu);
    }
}
