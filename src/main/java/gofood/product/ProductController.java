package gofood.product;

import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController<Product> {
    @Autowired
    public ProductController(ProductService service) {
        super(service);
    }
}
