package gofood.product;

import gofood.base.BaseService;

public class ProductService extends BaseService<Product> {
    protected ProductService(ProductRepository repo) {
        super(repo);
    }
}
