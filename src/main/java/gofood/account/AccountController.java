package gofood.account;

import com.fasterxml.jackson.annotation.JsonView;
import gofood.auth.util.JwtUtil;
import gofood.base.BaseController;
import gofood.order.Order;
import gofood.order.OrderService;
import gofood.serializer.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController extends BaseController<Account> {

    private final OrderService orderService;
    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService service, OrderService orderService) {
        super(service);
        this.orderService = orderService;
        this.accountService = service;
    }

    @Override
    @JsonView(View.General.class)
    public List<Account> getAll() {
        return super.getAll();
    }

    @GetMapping("/me")
    public Account getCurrentUser(HttpServletRequest request) {
        Integer id = JwtUtil.getRequestUserId(request);
        return service.getById(id);
    }

    @GetMapping("/me/orders")
    @JsonView(View.General.class)
    public List<Order> getCurrentUserOrders(HttpServletRequest request) {
        Integer id = JwtUtil.getRequestUserId(request);
        return service.getById(id).getOrders();
    }

    @PostMapping("/me/orders")
    public Order createOrder(HttpServletRequest request,@RequestBody Order order) {
        Integer id = JwtUtil.getRequestUserId(request);
        order.setCustomer(service.getById(id));
        return orderService.add(order);
    }

    @PostMapping("/{id}/avatar")
    public HttpStatus uploadAvatar(@PathVariable("id") Integer id, @RequestPart(value = "file") MultipartFile file) {
        return accountService.uploadAvatar(id, file);
    }

}
