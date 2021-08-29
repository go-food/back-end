package gofood.restaurant;

import gofood.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

public class Restaurant extends BaseEntity {
    @Column
    @Id
    private Integer id;
    @Column
    private String address;
    @Column
    private Integer cityId;
    @Column
    private Date openTime;
    @Column
    private Date closeTime;
    @Column
    private Boolean status;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
