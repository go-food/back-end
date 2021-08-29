package gofood.cartLines;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartLineService extends BaseService<CartLine> {
    @Autowired
    protected CartLineService(CartLineRepository repo) {
        super(repo);
    }
}
