package gofood.order;


import com.fasterxml.jackson.annotation.JsonView;
import gofood.base.BaseController;
import gofood.serializer.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController extends BaseController<Order> {
    @Autowired
    public OrderController(OrderService service) {
        super(service);
    }

    @Override
    @JsonView(View.General.class)
    public List<Order> getAll() {
        return super.getAll();
    }

    @Override
    @JsonView(View.General.class)
    public Order getById(Integer id) {
        return super.getById(id);
    }
}
