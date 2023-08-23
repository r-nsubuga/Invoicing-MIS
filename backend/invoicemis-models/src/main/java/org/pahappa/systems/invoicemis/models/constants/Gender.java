package org.pahappa.systems.invoicemis.models.constants;

public enum Gender {
    MALE("Male"),

    FEMALE("Female");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Gender (String name) {
        this.name = name;
    }
}
