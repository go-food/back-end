package gofood.menu;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MenuService extends BaseService<Menu> {
    @Autowired
    protected MenuService(MenuRepository repo) {
        super(repo);
    }
}
