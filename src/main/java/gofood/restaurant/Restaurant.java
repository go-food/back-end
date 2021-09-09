package gofood.restaurant;

import com.fasterxml.jackson.annotation.JsonView;
import gofood.account.Account;
import gofood.base.BaseEntity;
import gofood.menu.Menu;
import gofood.serializer.View;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {
    @Column(name = "address", nullable = false)
    @JsonView(View.General.class)
    private String address;

    @Column(name = "name", nullable = false)
    @JsonView(View.General.class)
    private String name;

    @Column(name = "openTime")
    @JsonView(View.General.class)
    private String openTime;

    @Column(name = "closeTime")
    @JsonView(View.General.class)
    private String closeTime;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;

    @Column
    @JsonView(View.General.class)
    private String image;

    @ManyToMany(mappedBy = "restaurants")
    private Set<Account> owners;

    public Restaurant(String address, String name, String description, String openTime, String closeTime) {
        this.address = address;
        this.name = name;
        this.description = description;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenTime() {
        return openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Set<Account> getOwners() {
        return owners;
    }

    public void setOwners(Set<Account> owners) {
        this.owners = owners;
    }

}
