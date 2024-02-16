package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @NotBlank(message = "Error. Description cannot be blank.")
    @Size(max = 150)
    private String description;

    @ManyToMany
    private List<Job> jobs = new ArrayList<>();

    //no-arg constructor for Hibernate to create an object
    public Skill() {};

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    //do i want a setter for this??
//    public void setJobs(List<Job> jobs) {
//        this.jobs = jobs;
//    }
}

//Task 2: add a field for longer skill description with getter/setter.
//Task 2: add @Entity annotation and no-arg constructor
//Check if you want a setter for List<Job>