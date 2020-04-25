package com.finalproject.finalproject.Models;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employees {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "jobposition")
    private String jobPosition;

    public Employees(){

    }

    public Employees(String id, String firstName, String lastName, String jobPosition) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobPosition = jobPosition;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobPosition(){ return jobPosition; }

    public void setJobPosition(String jobPosition) {this.jobPosition = jobPosition; }

}
