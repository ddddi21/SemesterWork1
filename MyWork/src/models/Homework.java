package models;

import java.sql.Date;
import java.util.Objects;

public class Homework {
    private Long id;
    private String hw_text;
    private String subject;
    private Integer group_number;
    private Date deadline;
    private Boolean isMake;

    public Homework(Long id, String hw_text, String subject, Integer group_number, Date deadline) {

        this.id = id;
        this.hw_text = hw_text;
        this.subject = subject;
        this.group_number = group_number;
        this.deadline = deadline;
    }

    public Homework() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHw_text() {
        return hw_text;
    }

    public void setHw_text(String hw_text) {
        this.hw_text = hw_text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getGroup_number() {
        return group_number;
    }

    public void setGroup_number(Integer group_number) {
        this.group_number = group_number;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Boolean getMake() {
        return isMake;
    }

    public void setMake(Boolean make) {
        isMake = make;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return Objects.equals(id, homework.id) &&
                Objects.equals(hw_text, homework.hw_text) &&
                Objects.equals(subject, homework.subject) &&
                Objects.equals(group_number, homework.group_number) &&
                Objects.equals(deadline, homework.deadline) &&
                Objects.equals(isMake, homework.isMake);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hw_text, subject, group_number, deadline, isMake);
    }

    @Override
    public String toString() {
        return subject+"#%#"+hw_text+"#%#"+deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = Date.valueOf(deadline);
    }
}
