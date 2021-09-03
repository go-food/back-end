package gofood.product;

import gofood.base.BaseService;
import gofood.productCategory.ProductCategoryRepository;
import gofood.restaurant.Restaurant;
import gofood.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService extends BaseService<Product> {
    private final RestaurantRepository restaurantRepository;
    private final ProductCategoryRepository productCategoryRepository;
    ProductRepository productRepository;

    @Autowired
    protected ProductService(ProductRepository repo, RestaurantRepository restaurantRepository, ProductCategoryRepository productCategoryRepository) {
        super(repo);
        this.restaurantRepository = restaurantRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository=repo;
    }

    @Override
    public Product add(Product product) {
        product.setRestaurant(restaurantRepository.findById(product.getRestaurant().getId()).get());
        product.setCategory(productCategoryRepository.findById(product.getCategory().getId()).get());
        return super.add(product);
    }
    public List<Product> findRestaurant(String name){
        return productRepository.findAllByNameContains(name);
    }
}
