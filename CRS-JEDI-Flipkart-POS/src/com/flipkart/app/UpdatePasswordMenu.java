package com.flipkart.app;

import com.flipkart.service.UserInterface;
import com.flipkart.service.UserServiceImpl;

public class UpdatePasswordMenu {
    public static void showUpdatePasswordMenu() {

        UserInterface user = new UserServiceImpl();
        user.updatePassword();
    }
}
