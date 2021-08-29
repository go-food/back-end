package gofood.cartLines;

import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartLines")
public class CartLinesController extends BaseController<CartLines> {
    @Autowired
    public CartLinesController(CartLinesService service) {
        super(service);
    }
}
