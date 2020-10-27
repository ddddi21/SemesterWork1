package models;

import java.util.List;
import java.util.Objects;

public class Teacher extends User {
    private Long teacher_id;
    //    private Long id;
//    private String firstName;
//    private String lastName;
//    private Integer age;
//    private String school;
    private Integer groups;
    private String subject;
    private Long user_id;


    public Teacher(String email, String password) {
        super(email, password);
    }


    public Teacher(String username, String password, String email) {
        super(username, password, email);
    }

    public Teacher(Integer groups, String subject) {
        this.groups = groups;
        this.subject = subject;
    }


    public Teacher(String email, String password, Integer groups, String subject) {
        super(email, password);
        this.groups = groups;
        this.subject = subject;
    }

    public Teacher(String username, String password, String email, Integer groups, String subject) {
        super(username, password, email);
        this.groups = groups;
        this.subject = subject;
    }

    public Teacher(Integer groups, String subject, Long user_id) {
        this.groups = groups;
        this.subject = subject;
        this.user_id = user_id;
    }

    public Teacher(String first_name, String lastName, Integer age, String email, String password, String role, Integer groups,String subject, Long user_id) {
        super(first_name, lastName, age, email, password, role);
        this.groups = groups;
        this.subject = subject;
        this.user_id = user_id;
    }

    public Teacher(String email, String password, Integer groups,String subject, Long user_id) {
        super(email, password);
        this.groups = groups;
        this.subject = subject;
        this.user_id = user_id;
    }

    public Teacher(String username, String password, String email, Integer groups, String subject, Long user_id) {
        super(username, password, email);
        this.groups = groups;
        this.subject = subject;
        this.user_id = user_id;
    }


    public Teacher(Long teacher_id, Long user_id, String subject) {
        this.teacher_id = teacher_id;
        this.user_id = user_id;
        this.subject = subject;
    }

    public Teacher(Long id, String subjects) {
        this.user_id = id;
        this.subject = subjects;
    }

    public Teacher(Long id, String subjects, Integer group) {
        this.user_id = id;
        this.subject = subjects;
        this.groups = group;
    }

    public Teacher(Long teacher_id, Long user_id, String subject, Integer group_number) {
        this.teacher_id = teacher_id;
        this.user_id = user_id;
        this.subject = subject;
        this.groups = group_number;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }



    public Integer getGroups() {
        return groups;
    }

    public void setGroups(Integer groups) {
        this.groups = groups;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
