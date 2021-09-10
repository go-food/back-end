package gofood.restaurant;

import com.fasterxml.jackson.annotation.JsonView;
import gofood.base.BaseController;
import gofood.menu.Menu;
import gofood.serializer.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/restaurants")
public class RestaurantController extends BaseController<Restaurant> {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService service) {
        super(service);
        this.restaurantService = service;
    }

    @Override
    @JsonView(View.General.class)
    public List<Restaurant> getAll() {
        return super.getAll();
    }

    @PostMapping("/{id}/menus")
    public Menu addMenuToRestaurant(@PathVariable("id") Integer restaurantId, @RequestBody Menu menu) {
        return restaurantService.addMenuToRestaurant(restaurantId, menu);
    }

    @PostMapping("/{id}/image")
    public HttpStatus uploadImage(@PathVariable("id") Integer id, @RequestPart(value = "file") MultipartFile file) {
        return restaurantService.uploadImage(id, file);
    }

    @PostMapping("/{id}/owners")
    public HttpStatus addOwner(@PathVariable("id") Integer restaurantId, @RequestBody Integer accountId) {
        return restaurantService.addOwner(restaurantId, accountId);
    }
}
