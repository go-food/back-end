package gofood.orderlines;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderLineService extends BaseService<OrderLine> {
    @Autowired
    protected OrderLineService(OrderLineRepository repo) {
        super(repo);
    }
}
