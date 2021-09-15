package gofood.restaurant;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.node.TextNode;
import gofood.base.BaseController;
import gofood.menu.Menu;
import gofood.request.Request;
import gofood.serializer.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Override
    @JsonView(View.Detail.class)
    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable("id") Integer id) {
        return super.getById(id);
    }

    @JsonView(View.Admin.class)
    @GetMapping("/{id}/dashboard")
    public Restaurant getDashboardDataById(@PathVariable("id") Integer id) {
        return super.getById(id);
    }

    @PostMapping("/{id}/menus")
    public Menu addMenuToRestaurant(@PathVariable("id") Integer restaurantId, @RequestBody Menu menu) {
        return restaurantService.addMenuToRestaurant(restaurantId, menu);
    }

    @PostMapping("/{id}/requests")
    public Request addRequestToRestaurant(@PathVariable("id") Integer restaurantId, @RequestBody Request request) {
        return restaurantService.addRequestToRestaurant(restaurantId, request);
    }

    @PostMapping("/{id}/image")
    public HttpStatus uploadImage(@PathVariable("id") Integer id, @RequestPart(value = "file") MultipartFile file) {
        return restaurantService.uploadImage(id, file);
    }

    @PostMapping("/{id}/owners")
    public HttpStatus addOwner(@PathVariable("id") Integer restaurantId, @RequestBody TextNode email) {
        return restaurantService.addOwner(restaurantId, email.asText());
    }

    @DeleteMapping("/{id}/owners/{ownerId}")
    public HttpStatus deleteOwner(@PathVariable("id") Integer restaurantId, @PathVariable("ownerId") Integer ownerId) {
        return restaurantService.deleteOwner(restaurantId, ownerId);
    }
}
