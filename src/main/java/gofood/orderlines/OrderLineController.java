package gofood.orderlines;

import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/order-lines")
public class OrderLineController extends BaseController<OrderLine> {
    @Autowired
    public OrderLineController(OrderLineService service) {
        super(service);
    }
}
