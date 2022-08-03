//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.flipkart.constant;

/**
 * Enumeration class for RoleConstant Types
 */
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

    /**
     * Method to get Role object from String
     * @param role
     * @return Role object
     */
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

    public static Role intToName(int role) {
        Role userRole = null;
        if (role == 1) {
            userRole = ADMIN;
        } else if (role == 3) {
            userRole = PROFESSOR;
        } else if (role == 2) {
            userRole = STUDENT;
        }

        return userRole;
    }

    public static int toInt(Role role) {
        int userRole = 0;
        if (role == ADMIN) {
            userRole = 1;
        } else if (role == PROFESSOR) {
            userRole = 3;
        } else if (role == STUDENT) {
            userRole = 2;
        }

        return userRole;
    }
}
