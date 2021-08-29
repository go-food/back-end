package gofood.cartLines;

import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/cart-lines")
public class CartLineController extends BaseController<CartLine> {
    @Autowired
    public CartLineController(CartLineService service) {
        super(service);
    }
}
