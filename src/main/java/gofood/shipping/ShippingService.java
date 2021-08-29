package gofood.shipping;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShippingService extends BaseService<Shipping> {
    @Autowired
    protected ShippingService(ShippingRepository repo) {
        super(repo);
    }
}
