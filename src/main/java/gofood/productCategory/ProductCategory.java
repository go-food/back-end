package gofood.productCategory;

import gofood.base.BaseEntity;
import gofood.cartLines.CartLine;
import gofood.product.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "product_category")
public class ProductCategory extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="category")
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
