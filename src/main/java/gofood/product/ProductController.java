package gofood.product;

import gofood.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController extends BaseController<Product> {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService service) {
        super(service);
        this.productService = service;
    }

    @PostMapping("/{id}/image")
    public HttpStatus uploadImage(@PathVariable("id") Integer id, @RequestPart(value = "file") MultipartFile file) {
        return productService.uploadImage(id, file);
    }

}
