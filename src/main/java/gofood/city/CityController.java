package gofood.city;

import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citys")
public class CityController extends BaseController<City> {
    @Autowired
    public CityController(CityService service) {
        super(service);
    }
}
