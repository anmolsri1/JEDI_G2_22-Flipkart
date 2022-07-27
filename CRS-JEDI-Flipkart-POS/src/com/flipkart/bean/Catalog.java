package com.flipkart.bean;

public class Catalog {
    public Course[] getCourseList() {
        return courseList;
    }

    public void setCourseList(Course[] courseList) {
        this.courseList = courseList;
    }

    private Course[] courseList;

}
