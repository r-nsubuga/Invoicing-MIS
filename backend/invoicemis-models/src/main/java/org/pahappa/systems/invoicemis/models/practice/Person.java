package org.pahappa.systems.invoicemis.models.practice;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.sers.webutils.model.BaseEntity;

@Entity
@Table(name="people")
public class Person extends BaseEntity{
    private String firstName;
    private String lastName;


    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}