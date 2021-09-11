package gofood.restaurant;

import gofood.account.Account;
import gofood.account.AccountRepository;
import gofood.base.BaseService;
import gofood.file.FileService;
import gofood.menu.Menu;
import gofood.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RestaurantService extends BaseService<Restaurant> {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    private final AccountRepository accountRepository;
    private final FileService fileService;

    @Autowired
    protected RestaurantService(RestaurantRepository repo, MenuRepository menuRepository, AccountRepository accountRepository, FileService fileService) {
        super(repo);
        this.restaurantRepository = repo;
        this.menuRepository = menuRepository;
        this.accountRepository = accountRepository;
        this.fileService = fileService;
    }

    public List<Restaurant> findRestaurantByName(String name) {
        return restaurantRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Menu addMenuToRestaurant(Integer restaurantId, Menu menu) {
        Restaurant restaurant = repo.findById(restaurantId).get();
        menu.setRestaurant(restaurant);
        return menuRepository.save(menu);
    }

    public HttpStatus uploadImage(Integer id, MultipartFile multipartFile) {
        Restaurant restaurant = repo.findById(id).get();
        restaurant.setImage(fileService.uploadImage("restaurants/", multipartFile));
        return HttpStatus.OK;
    }

    public HttpStatus addOwner(Integer restaurantId, Integer accountId) {
        Restaurant restaurant = repo.findById(restaurantId).get();
        Account account = accountRepository.findById(accountId).get();
        if (account.getRestaurants().contains(restaurant))
            throw new RuntimeException("Account " + account.getId() + " is already an owner of restaurant!");
        account.getRestaurants().add(restaurant);
        return HttpStatus.OK;
    }

    @Override
    public Restaurant updateById(Restaurant updatedRestaurant, Integer id) {
        Restaurant restaurant = repo.findById(id).get();
        if (updatedRestaurant.getName() != null) restaurant.setName(updatedRestaurant.getName());
        if (updatedRestaurant.getAddress() != null) restaurant.setAddress(updatedRestaurant.getAddress());
        if (updatedRestaurant.getDescription() != null) restaurant.setDescription(updatedRestaurant.getDescription());
        if (updatedRestaurant.getOpenTime() != null) restaurant.setOpenTime(updatedRestaurant.getOpenTime());
        if (updatedRestaurant.getCloseTime() != null) restaurant.setCloseTime(updatedRestaurant.getCloseTime());
        return restaurant;
    }
}
