package gofood.menu;

import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/menus")
public class MenuController extends BaseController<Menu> {
    @Autowired
    public MenuController(MenuService service) {
        super(service);
    }
}
