package model;

import java.util.Date;

public class Class {
    private int class_id;
    private String class_name;
    private int student_id;
    private String student_code;
    private String studentName;
    private Date student_birthday;
    private boolean student_status;
    private String student_username;
    private int student_year_id;
    private String year_name;
    private Double year_price;


    public Class() {
    }

    public Class(int class_id, String class_name) {
        this.class_id = class_id;
        this.class_name = class_name;
    }

    public Class(int student_id, String student_code, String studentName, Date student_birthday, boolean student_status, String student_username, int student_year_id, int class_id, String year_name, Double year_price, String class_name) {
        this.student_id = student_id;
        this.studentName = studentName;
        this.student_code = student_code;
        this.student_birthday = student_birthday;
        this.student_status = student_status;
        this.student_username = student_username;
        this.student_year_id = student_year_id;
        this.class_id = class_id;
        this.class_name = class_name;
        this.year_name = year_name;
        this.year_price = year_price;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getStudent_birthday() {
        return student_birthday;
    }

    public void setStudent_birthday(Date student_birthday) {
        this.student_birthday = student_birthday;
    }

    public boolean isStudent_status() {
        return student_status;
    }

    public void setStudent_status(boolean student_status) {
        this.student_status = student_status;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }

    public int getStudent_year_id() {
        return student_year_id;
    }

    public void setStudent_year_id(int student_year_id) {
        this.student_year_id = student_year_id;
    }

    public String getYear_name() {
        return year_name;
    }

    public void setYear_name(String year_name) {
        this.year_name = year_name;
    }

    public Double getYear_price() {
        return year_price;
    }

    public void setYear_price(Double year_price) {
        this.year_price = year_price;
    }
}