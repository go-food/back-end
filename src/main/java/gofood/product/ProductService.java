package gofood.product;

import gofood.base.BaseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService extends BaseService<Product> {
    protected ProductService(ProductRepository repo) {
        super(repo);
    }
}
