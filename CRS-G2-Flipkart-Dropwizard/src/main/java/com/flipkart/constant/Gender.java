package com.flipkart.constant;

/**
 * Enumeration class for Gender
 */
public enum Gender {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    private final int gender;

    /**
     * Parameterized Constructor
     * @param gender
     */
    private Gender(int gender) {
        this.gender = gender;
    }

    /**
     * Method to return gender type in String
     * @return Gender name in String
     */

    public String toString() {
        String name = this.name();
        return name;
    }

    /**
     * Method to get Gender object depending upon user input
     * @param val
     * @return Gender object
     */
    public static Gender getName(int val) {
        Gender gender = OTHER;
        switch (val) {
            case 1:
                gender = MALE;
                break;
            case 2:
                gender = FEMALE;
        }

        return gender;
    }

    /**
     * Method to convert String to Gender object
     * @param val
     * @return Gender object
     */
    public static Gender stringToGender(String val) {
        Gender gender = OTHER;
        if (val.equalsIgnoreCase("male")) {
            gender = MALE;
        } else if (val.equalsIgnoreCase("female")) {
            gender = FEMALE;
        } else if (val.equalsIgnoreCase("other")) {
            gender = OTHER;
        }

        return gender;
    }
}
