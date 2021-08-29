package gofood.productCategory;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductCategoryService extends BaseService<ProductCategory> {
    @Autowired
    protected ProductCategoryService(ProductCategoryRepository repo) {
        super(repo);
    }
}
