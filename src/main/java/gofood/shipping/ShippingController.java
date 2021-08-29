package gofood.shipping;

import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/shippings")
public class ShippingController extends BaseController<Shipping> {
    @Autowired
    public ShippingController(ShippingService service) {
        super(service);
    }
}
