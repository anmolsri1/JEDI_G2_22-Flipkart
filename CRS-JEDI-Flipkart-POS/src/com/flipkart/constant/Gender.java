package com.flipkart.constant;

public enum Gender {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    private final int gender;

    private Gender(int gender) {
        this.gender = gender;
    }

    public String toString() {
        String name = this.name();
        return name;
    }

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
