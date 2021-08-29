package gofood.shipping;

import gofood.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Shipping extends BaseEntity {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
