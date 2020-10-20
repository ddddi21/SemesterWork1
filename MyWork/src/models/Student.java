package models;

import java.util.List;
import java.util.Objects;

public class Student extends User{
    private  Long student_id;
    private  Long user_id;
    //    private String school;
    private Integer group;

    public Student(String email, String password) {
        super(email, password);
    }

    public Student(String username, String password, String email) {
        super(username, password, email);
    }

    public Student(Integer group) {
        this.group = group;
    }


    public Student(Long user_id, Integer group){
        this.group = group;
        this.user_id = user_id;
    }

    public Student(String email, String password, Integer group) {
        super(email, password);
        this.group = group;
    }

    public Student(String username, String password, String email, Integer group) {
        super(username, password, email);
        this.group = group;
    }

    public Student(Long student_id, Long user_id, Integer group_number) {

        this.student_id = student_id;
        this.user_id = user_id;
        this.group = group_number;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
       return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
