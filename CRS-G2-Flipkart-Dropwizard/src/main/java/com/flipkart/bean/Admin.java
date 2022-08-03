package com.flipkart.bean;

import java.util.Date;

/**
 * @author Jedi-02
 * Admin bean class
 */

public class Admin extends User{
    private int adminId;
    private Date dateOfJoining;
    private Catalog[] catalogList;


    /**
     * Method to get Admin ID
     * @return Admin ID
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * Method to set admin id
     * @param adminId
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     * Method to get date of joining
     * @return Date of Joining
     */
    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    /**
     * Method to set date of joining
     * @param dateOfJoining
     */
    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    /**
     * Method to get catlog of courses
     * @return Catalog List
     */
    public Catalog[] getCatalogList() {
        return catalogList;
    }


    /**
     * Method to set Catalog List
     * @param catalogList
     */
    public void setCatalogList(Catalog[] catalogList) {
        this.catalogList = catalogList;
    }
}
