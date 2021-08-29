package gofood.restaurant;

import gofood.base.BaseController;
import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController extends BaseController<Restaurant> {
    @Autowired
    public RestaurantController(RestaurantService service) {
        super(service);
    }
}
