package models;

import java.util.List;
import java.util.Objects;

public class Student extends User{
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



    public Student(String email, String password, Integer group) {
        super(email, password);
        this.group = group;
    }

    public Student(String username, String password, String email, Integer group) {
        super(username, password, email);
        this.group = group;
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
