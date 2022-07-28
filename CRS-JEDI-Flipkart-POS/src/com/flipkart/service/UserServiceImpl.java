package com.flipkart.service;

import com.flipkart.dao.DummyData;

public class UserServiceImpl implements UserInterface{
    DummyData data;
    public UserServiceImpl(DummyData data) {
        this.data = data;
    }
    @Override
    public void getUserDetails() {

    }

    @Override
    public void updatePassword() {

    }

    @Override
    public boolean verifyCredentials(String username, String password, String role) {
        return true;
    }
}
