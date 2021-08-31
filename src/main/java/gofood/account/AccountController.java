package gofood.account;

import gofood.auth.util.JwtUtil;
import gofood.base.BaseController;
import gofood.exceptions.HttpUnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController extends BaseController<Account> {
    @Autowired
    public AccountController(AccountService service) {
        super(service);
    }

    @GetMapping("/me")
    public Account getCurrentUser(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, JwtUtil.COOKIE_NAME);
        if (cookie == null) throw new HttpUnauthorizedException();

        String idString = JwtUtil.extractId(cookie.getValue());
        if (idString == null) throw new HttpUnauthorizedException();

        return service.getById(Integer.valueOf(idString));
    }
}
