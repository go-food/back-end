package gofood.product;

import gofood.account.Account;
import gofood.base.BaseService;
import gofood.file.FileService;
import gofood.menu.MenuRepository;
import gofood.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService extends BaseService<Product> {
    private final FileService fileService;

    @Autowired
    protected ProductService(ProductRepository repo, FileService fileService) {
        super(repo);
        this.fileService = fileService;
    }

    @Override
    public HttpStatus deleteById(Integer id) {
        Product product = repo.findById(id).get();
        product.getOrderLines().forEach(orderLine -> orderLine.setProduct(null));
        return super.deleteById(id);
    }

    public HttpStatus uploadImage(Integer id, MultipartFile multipartFile) {
        Product product = repo.findById(id).get();
        product.setImage(fileService.uploadImage("products/", multipartFile));
        return HttpStatus.OK;
    }

    @Override
    public Product updateById(Product updatedProduct, Integer id) {
        Product product = repo.findById(id).get();
        if (updatedProduct.getName() != null) product.setName(updatedProduct.getName());
        if (updatedProduct.getPrice() != null) product.setPrice(updatedProduct.getPrice());
        if (updatedProduct.getDescription() != null) product.setDescription(updatedProduct.getDescription());
        return product;
    }
}
