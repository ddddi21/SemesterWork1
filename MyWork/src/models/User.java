package models;

import java.util.Objects;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private Integer age;
    private String password;
    private String email;
    //TODO(add photo_path)

    public User(){

    }

    public User(Long id, String first_name, String lastName, Integer age, String password, String email) {
        this.id = id;
        this.firstName = first_name;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.email = email;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String username, String password, String email) {
        this.firstName = username;
        this.password = password;
        this.email = email;
    }

    public User(Long id, String firstName, String lastName, String role, Integer age, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword());
    }
}