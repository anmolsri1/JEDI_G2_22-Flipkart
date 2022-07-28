package com.flipkart.dao;

import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import javafx.util.Pair;

import java.util.Map;

public class DummyData {
    public static Map<String, Pair<String,String>> mapGrades;
    public static Map<Integer, Catalog> catalog;
    public static Map<String, Catalog> selectedCourses;

    public static void init() {
        Pair<String, String> pair = new Pair<String,String>("C101","A");
//        pair.put("C101", new String("A"));
        mapGrades.put("S101",pair);
        mapGrades.put("S101",new Pair <String, String> ("C102", "A"));
        mapGrades.put("S101",new Pair <String, String> ("C103", "A"));
        mapGrades.put("S101",new Pair <String, String> ("C104", "A"));

        Catalog cat = new Catalog();
        cat.courseList.add(new Course("C101","Physics",true,"Amit Balyan"));
        cat.courseList.add(new Course("C102","Maths",true,"Amit Balyan"));
        cat.courseList.add(new Course("C103","Chemistry",true,"Amit Balyan"));
        cat.courseList.add(new Course("C104","English",true,"Amit Balyan"));
        cat.courseList.add(new Course("C105","English",true,"Amit Balyan"));
        cat.courseList.add(new Course("C106","English",true,"Amit Balyan"));

        catalog.put(1,cat);
        Catalog sel = new Catalog();
        sel.courseList.add(new Course("C101","Physics",true,"Amit Balyan"));
        sel.courseList.add(new Course("C102","Maths",true,"Amit Balyan"));
        sel.courseList.add(new Course("C105","English",true,"Amit Balyan"));
        sel.courseList.add(new Course("C106","English",true,"Amit Balyan"));
        selectedCourses.put("S101",sel);
    }

}
