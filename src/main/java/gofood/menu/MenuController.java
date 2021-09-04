package gofood.menu;

import gofood.base.BaseController;
import gofood.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/menus")
public class MenuController extends BaseController<Menu> {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService service) {
        super(service);
        this.menuService = service;
    }

    @PostMapping("/{id}/products")
    public Product addProductToMenu(@PathVariable("id") Integer menuId, @RequestBody Product product) {
        return menuService.addProductToMenu(menuId, product);
    }
}
