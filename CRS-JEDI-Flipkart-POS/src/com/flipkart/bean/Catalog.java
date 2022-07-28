package com.flipkart.bean;

import java.util.List;

public class Catalog {
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> courseList;

}
