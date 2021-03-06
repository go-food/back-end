package gofood.base;

import com.fasterxml.jackson.annotation.JsonView;
import gofood.serializer.View;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    @JsonView(View.General.class)
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public BaseEntity() {
    }

    public BaseEntity(Integer id) {
        this.id = id;
    }
}