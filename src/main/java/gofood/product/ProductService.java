package gofood.product;

import gofood.base.BaseService;
import gofood.menu.MenuRepository;
import gofood.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public HttpStatus deleteById(Integer id) {
        Product product = repo.findById(id).get();
        product.getOrderLines().forEach(orderLine -> orderLine.setProduct(null));
        return super.deleteById(id);
    }

    public List<Product> findRestaurant(String name) {
        return productRepository.findAllByNameContains(name);
    }
}
