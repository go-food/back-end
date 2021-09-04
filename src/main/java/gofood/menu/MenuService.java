package gofood.menu;

import gofood.base.BaseService;
import gofood.product.Product;
import gofood.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MenuService extends BaseService<Menu> {
    private final ProductRepository productRepository;

    @Autowired
    protected MenuService(MenuRepository repo, ProductRepository productRepository) {
        super(repo);
        this.productRepository = productRepository;
    }

    public Product addProductToMenu(Integer menuId, Product product) {
        Menu menu = repo.findById(menuId).get();
        product.setMenu(menu);
        System.out.println(menu.getRestaurant());
        product.setRestaurant(menu.getRestaurant());
        return productRepository.save(product);
    }
}
