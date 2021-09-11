package gofood.request;

import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/request")
public class RequestController extends BaseController<Request> {
    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService service) {
        super(service);
        this.requestService = service;
    }

}
