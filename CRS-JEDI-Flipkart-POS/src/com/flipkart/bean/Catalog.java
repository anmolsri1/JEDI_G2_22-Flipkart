package com.flipkart.bean;

import java.util.List;

/**
 * @author Jedi-03
 * Catalog bean class
 */

public class Catalog {
    /**
     * Method to get list of courses and returh
     * @return Course List
     */
    public List<Course> getCourseList() {
        return courseList;
    }

    /**
     * Function to set list of courses
     * @param courseList
     */
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> courseList;

}
