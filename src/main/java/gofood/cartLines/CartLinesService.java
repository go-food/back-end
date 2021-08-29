package gofood.cartLines;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartLinesService extends BaseService<CartLines> {
    @Autowired
    protected CartLinesService(CartLinesRepository repo) {
        super(repo);
    }
}
