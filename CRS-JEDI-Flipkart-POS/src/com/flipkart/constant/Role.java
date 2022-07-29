//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.flipkart.constant;

public enum Role {
    ADMIN,
    PROFESSOR,
    STUDENT;

    private Role() {
    }

    public String toString() {
        String name = this.name();
        return name;
    }

    public static Role stringToName(String role) {
        Role userRole = null;
        if (role.equalsIgnoreCase("ADMIN")) {
            userRole = ADMIN;
        } else if (role.equalsIgnoreCase("PROFESSOR")) {
            userRole = PROFESSOR;
        } else if (role.equalsIgnoreCase("STUDENT")) {
            userRole = STUDENT;
        }

        return userRole;
    }
}
