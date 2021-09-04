package gofood.account;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AccountService extends BaseService<Account> {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Autowired
    protected AccountService(AccountRepository repo, PasswordEncoder passwordEncoder) {
        super(repo);
        this.accountRepository = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Account add(Account account) {
        boolean emailExists = accountRepository.findByEmail(account.getEmail()).isPresent();
        if (emailExists) throw new RuntimeException("Email already exists!");
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return super.add(account);
    }

    public Account getUserByEmailAndPassword(String email, String password) {
        Optional<Account> accountOptional = accountRepository.findByEmail(email);
        if (accountOptional.isEmpty()) return null;
        Account account = accountOptional.get();
        if (passwordEncoder.matches(password, account.getPassword())) {
            return account;
        }
        return null;
    }

    @Override
    public Account updateById(Account updatedAccount, Integer id) {
        Account account = repo.findById(id).get();
        if (updatedAccount.getName() != null) account.setName(updatedAccount.getName());
        if (updatedAccount.getEmail() != null) account.setEmail(updatedAccount.getEmail());
        if (updatedAccount.getAddress() != null) account.setAddress(updatedAccount.getAddress());
        if (updatedAccount.getPhoneNumber() != null) account.setPhoneNumber(updatedAccount.getPhoneNumber());
        return account;
    }
}
