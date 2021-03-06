package gofood.order;

import gofood.account.Account;
import gofood.account.AccountRepository;
import gofood.base.BaseService;
import gofood.orderlines.OrderLine;
import gofood.product.ProductRepository;
import gofood.restaurant.RestaurantRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderService extends BaseService<Order> {
    private final AccountRepository accountRepository;
    private final RestaurantRepository restaurantRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository repo, AccountRepository accountRepository, RestaurantRepository restaurantRepository, ProductRepository productRepository) {
        super(repo);
        this.accountRepository = accountRepository;
        this.restaurantRepository = restaurantRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order add(Order order) {
        if (order.getCustomer() == null)
            order.setCustomer(accountRepository.findById(order.getCustomer().getId()).get());
        order.setRestaurant(restaurantRepository.findById(order.getRestaurant().getId()).get());
        Double total = 0.0;
        for (OrderLine orderLine : order.getCartLines()) {
            orderLine.setProduct(productRepository.findById(orderLine.getProduct().getId()).get());
            orderLine.setOrder(order);
            orderLine.setPrice(orderLine.getProduct().getPrice());
            orderLine.setItemTotal(orderLine.getProduct().getPrice() * orderLine.getQuantity());
            total += orderLine.getItemTotal();
        }
        order.setTotal(total);
        Order createdOrder = super.add(order);
        Account customer = accountRepository.findById(createdOrder.getCustomer().getId()).get();

        // email code

        return createdOrder;
    }

    @Override
    public Order updateById(Order updatedOrder, Integer id) {
        Order order = repo.findById(id).get();
        if (updatedOrder.getStatus() != null) order.setStatus(updatedOrder.getStatus());
        return order;
    }
}
