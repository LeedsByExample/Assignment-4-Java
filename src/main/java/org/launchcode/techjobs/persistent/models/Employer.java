package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Error. Location cannot be blank.")
    @Size(max = 150)
    private String location;

    @OneToMany
    @JoinColumn(name = "employer_id")
    private List<Job> jobs = new ArrayList<>();

    //no-arg constructor needed for hibernate to create an object
    public Employer() {
    };

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    //do I want a setter for this???
//    public void setJobs(List<Job> jobs) {
//        this.jobs = jobs;
//    }
}

//Task 2: add location field, validations, and getter/setter. "For the purposes of this app, an employer can only have one location." I assume, since not specified, that an employer can only have one location, but a location can have many employers? Do I need to add a one-to-many annotation? Idk. Return to this later.
//Task 2: add @Entity, and no-arg constructor for Hibernate to create object
//Check if I need a setter for List<Job>