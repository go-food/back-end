package gofood.cart;

import gofood.account.AccountRepository;
import gofood.base.BaseService;
import gofood.cartLines.CartLine;
import gofood.product.ProductRepository;
import gofood.restaurant.Restaurant;
import gofood.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartService extends BaseService<Cart> {
    private final AccountRepository accountRepository;
    private final RestaurantRepository restaurantRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository repo, AccountRepository accountRepository, RestaurantRepository restaurantRepository, ProductRepository productRepository) {
        super(repo);
        this.accountRepository = accountRepository;
        this.restaurantRepository = restaurantRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Cart add(Cart cart) {
        cart.setCustomer(accountRepository.findById(cart.getCustomer().getId()).get());
        cart.setRestaurant(restaurantRepository.findById(cart.getRestaurant().getId()).get());
        Double total = 0.0;
        for (CartLine cartLine : cart.getCartLines()) {
            cartLine.setProduct(productRepository.findById(cartLine.getProduct().getId()).get());
            cartLine.setCart(cart);
            cartLine.setItemTotal(cartLine.getProduct().getPrice() * cartLine.getQuantity());
            total += cartLine.getItemTotal();
        }
        cart.setTotal(total);
        return super.add(cart);
    }
}
