package gofood.productCategory;

import gofood.account.AccountService;
import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productCategories")
public class ProductCategoryController extends BaseController<ProductCategory> {
    @Autowired
    public ProductCategoryController(ProductCategoryService service) {
        super(service);
    }
}
