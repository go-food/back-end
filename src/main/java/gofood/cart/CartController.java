package gofood.cart;


import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/carts")
public class CartController extends BaseController<Cart> {
    @Autowired
    public CartController(CartService service) {
        super(service);
    }
}
