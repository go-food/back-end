package gofood.account;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService extends BaseService<Account> {
    @Autowired
    protected AccountService(AccountRepository repo) {
        super(repo);
    }
}
