package com.flipkart.dao;

import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyData {
    public HashMap<String, Pair<String,String>> mapGrades;
    public  HashMap<Integer, Catalog> catalog;
    public  HashMap<String, Catalog> selectedCourses;
    public HashMap<String, List<Student>> enrolledStudents;

    public DummyData() {
        Pair<String, String> pair = new Pair<String,String>("C101","A");
        mapGrades = new HashMap<String, Pair<String, String>>();
//        pair.put("C101", new String("A"));
        mapGrades.put("S101",pair);
        mapGrades.put("S101",new Pair <String, String> ("C102", "A"));
        mapGrades.put("S101",new Pair <String, String> ("C103", "A"));
        mapGrades.put("S101",new Pair <String, String> ("C104", "A"));

        Catalog cat = new Catalog();
        catalog = new HashMap<Integer,Catalog>();
        cat.courseList = new ArrayList<Course>();
        cat.courseList.add(new Course("C101","Physics",true,"Amit Balyan"));
        cat.courseList.add(new Course("C102","Maths",true,"Amit Balyan"));
        cat.courseList.add(new Course("C103","Chemistry",true,"Amit Balyan"));
        cat.courseList.add(new Course("C104","English",true,"Amit Balyan"));
        cat.courseList.add(new Course("C105","English",true,"Amit Balyan"));
        cat.courseList.add(new Course("C106","English",true,"Amit Balyan"));

        catalog.put(1,cat);
        Catalog sel = new Catalog();
        selectedCourses = new HashMap<String,Catalog>();
        sel.courseList = new ArrayList<Course>();
        sel.courseList.add(new Course("C101","Physics",true,"Amit Balyan"));
        sel.courseList.add(new Course("C102","Maths",true,"Amit Balyan"));
        sel.courseList.add(new Course("C105","English",true,"Amit Balyan"));
        sel.courseList.add(new Course("C106","English",true,"Amit Balyan"));
        selectedCourses.put("S101",sel);

        enrolledStudents = new HashMap<String, List<Student>>();
        List<Student> students= new ArrayList<Student>();
        students.add(new Student("S101","Abc","","",1,"Male","S101",1));
        students.add(new Student("S102","Bcd","","",1,"Male","S101",1));
        students.add(new Student("S103","Cde","","",1,"Female","S101",1));
        students.add(new Student("S104","Dfef","","",1,"Female","S101",1));
        enrolledStudents.put("C101",students);
        enrolledStudents.put("C102",students);
        enrolledStudents.put("C103",students);
        enrolledStudents.put("C104",students);
        enrolledStudents.put("C105",students);
    }

    public static void init() {

    }

}
