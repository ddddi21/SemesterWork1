package models;

import java.util.List;
import java.util.Objects;

public class Teacher extends User {
//    private Long id;
//    private String firstName;
//    private String lastName;
//    private Integer age;
//    private String school;
    private List <Group> groups;
    private List<String> subject;

    public Teacher(String email, String password) {
        super(email, password);
    }


    public Teacher(String username, String password, String email) {
        super(username, password, email);
    }

    public Teacher(List<Group> groups, List<String> subject) {
        this.groups = groups;
        this.subject = subject;
    }


    public Teacher(String email, String password, List<Group> groups, List<String> subject) {
        super(email, password);
        this.groups = groups;
        this.subject = subject;
    }

    public Teacher(String username, String password, String email, List<Group> groups, List<String> subject) {
        super(username, password, email);
        this.groups = groups;
        this.subject = subject;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
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
