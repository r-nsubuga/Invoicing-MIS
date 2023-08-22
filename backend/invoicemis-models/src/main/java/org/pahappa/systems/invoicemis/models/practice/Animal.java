package org.pahappa.systems.invoicemis.models.practice;

import org.sers.webutils.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="animals")
public class Animal extends BaseEntity {
    private String animalName;
    private int  animalAge;

    @Column(name="animal_name")
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Column(name="animal_age")
    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }
}
