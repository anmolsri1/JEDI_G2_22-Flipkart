package com.flipkart.bean;

/**
 * @author Jedi-02
 * Bean class to get and set grade
 */
public class Grade {
    private String grade;

    public Grade(String grade) {
        this.grade = grade;
    }

    /**
     * Method to get grade
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Method to set grade
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
