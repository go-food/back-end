package gofood.product;

import gofood.base.BaseService;
import gofood.menu.MenuRepository;
import gofood.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService extends BaseService<Product> {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    ProductRepository productRepository;

    @Autowired
    protected ProductService(ProductRepository repo, RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
        super(repo);
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
        this.productRepository = repo;
    }

    @Override
    public Product add(Product product) {
        product.setRestaurant(restaurantRepository.findById(product.getRestaurant().getId()).get());
        product.setCategory(menuRepository.findById(product.getCategory().getId()).get());
        return super.add(product);
    }

    public List<Product> findRestaurant(String name) {
        return productRepository.findAllByNameContains(name);
    }
}
