package com.flipkart.bean;

import java.util.Date;

public class Admin extends User{
    private String adminId;
    private Date dateOfJoining;
    private Catalog[] catalogList;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Catalog[] getCatalogList() {
        return catalogList;
    }

    public void setCatalogList(Catalog[] catalogList) {
        this.catalogList = catalogList;
    }
}
