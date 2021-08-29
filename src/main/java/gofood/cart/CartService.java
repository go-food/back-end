package gofood.cart;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartService extends BaseService<Cart> {
    @Autowired
    protected CartService(CartRepository repo) {
        super(repo);
    }
}
