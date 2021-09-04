package gofood.restaurant;

import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/restaurants")
public class RestaurantController extends BaseController<Restaurant> {
    @Autowired
    public RestaurantController(RestaurantService service) {
        super(service);
    }

    @Autowired
    public RestaurantService restaurantService;

    @PostMapping (value = "/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("filename") String filename, @RequestParam("file")MultipartFile file) {
        return new ResponseEntity<>(restaurantService.uploadImage("gofoodbucket", filename, file), HttpStatus.OK);
    }
}
