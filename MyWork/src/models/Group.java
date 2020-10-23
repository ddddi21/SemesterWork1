package models;

import com.sun.javafx.image.IntPixelGetter;

import java.util.List;
import java.util.Objects;

public class Group {
    private List<Student> students;
    private Integer studentsCount;
    private Integer number;
    private Integer hw_id;

    public Group(List<Student> students, Integer studentsCount, Integer number, Integer hw_id) {
        this.students = students;
        this.studentsCount = studentsCount;
        this.number = number;
        this.hw_id = hw_id;
    }

    public Group(Integer studentsCount, Integer number, Integer hw_id) {
        this.studentsCount = studentsCount;
        this.number = number;
        this.hw_id = hw_id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getHw_id() {
        return hw_id;
    }

    public void setHw_id(Integer hw_id) {
        this.hw_id = hw_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(number, group.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, studentsCount, number, hw_id);
    }
}
