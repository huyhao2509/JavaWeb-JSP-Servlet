package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String student_code;
    private String studentName;
    private Date student_birthday;
    private boolean student_status;
    private String student_username;
    private int student_year_id;
    private int student_class_id;

    // detail
    private String year_name;
    private Double year_price;
    private String class_name;

    public Student() {
    }

    public Student(String student_code, String studentName, Date student_birthday, boolean student_status, String student_username, int student_year_id, int student_class_id) {
        this.student_code = student_code;
        this.studentName = studentName;
        this.student_birthday = student_birthday;
        this.student_status = student_status;
        this.student_username = student_username;
        this.student_year_id = student_year_id;
        this.student_class_id = student_class_id;
    }

    public Student(String class_name, String studentName, String year_name, Double year_price) {
        this.class_name = class_name;
        this.studentName = studentName;
        this.year_name = year_name;
        this.year_price = year_price;
    }

    public Student(int student_class_id, String student_code, String studentName, java.sql.Date student_birthday, boolean student_status, String class_name, String year_name) {
        this.student_class_id = student_class_id;
        this.student_code = student_code;
        this.studentName = studentName;
        this.student_birthday = student_birthday;
        this.student_status = student_status;
        this.class_name = class_name;
        this.year_name = year_name;
    }

    public Student(String student_code, String studentName, Date student_birthday, boolean student_status, String student_username, int student_year_id, int student_class_id, String year_name, Double year_price, String class_name) {
        this.student_code = student_code;
        this.studentName = studentName;
        this.student_birthday = student_birthday;
        this.student_status = student_status;
        this.student_username = student_username;
        this.student_year_id = student_year_id;
        this.student_class_id = student_class_id;
        this.year_name = year_name;
        this.year_price = year_price;
        this.class_name = class_name;
    }

    public Student(String class_name, String year_name, Double year_price) {
        this.class_name = class_name;
        this.year_name = year_name;
        this.year_price = year_price;
    }

    public Student(String student_code, String studentName, Date student_birthday, boolean student_status, String student_username, int student_year_id, int student_class_id, String year_name, String class_name) {
        this.student_code = student_code;
        this.studentName = studentName;
        this.student_birthday = student_birthday;
        this.student_status = student_status;
        this.student_username = student_username;
        this.student_year_id = student_year_id;
        this.student_class_id = student_class_id;
        this.year_name = year_name;
        this.class_name = class_name;
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

    public int getStudent_class_id() {
        return student_class_id;
    }

    public void setStudent_class_id(int student_class_id) {
        this.student_class_id = student_class_id;
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

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getStudentBirthdayAsString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(this.student_birthday);
    }
}