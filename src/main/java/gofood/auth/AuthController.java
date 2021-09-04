package gofood.auth;

import gofood.account.Account;
import gofood.account.AccountService;
import gofood.auth.util.JwtUtil;
import gofood.exception.HttpUnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    private final AccountService accountService;

    @Autowired
    public AuthController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        Account account = accountService.getUserByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if (account == null) throw new HttpUnauthorizedException();
        String token = JwtUtil.generateToken(account.getId().toString());
        response.addCookie(JwtUtil.createCookie(token));
        return token;
    }

    @PostMapping("/logout")
    public HttpStatus logout(HttpServletResponse response) {
        response.addCookie(JwtUtil.clearCookie());
        return HttpStatus.OK;
    }
}
