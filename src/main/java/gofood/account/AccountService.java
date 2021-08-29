package gofood.account;

import gofood.base.BaseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService extends BaseService<Account> {
    protected AccountService(AccountRepository repo) {
        super(repo);
    }
}
