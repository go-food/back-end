package gofood.city;

import gofood.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;

public class City extends BaseEntity {
    @Column
    @Id
    private Integer id;
    @Column
    private String name;

    public Integer getId() {
        return id;
    }

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
