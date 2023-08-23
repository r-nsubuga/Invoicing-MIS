package org.pahappa.systems.invoicemis.models.client;

import org.sers.webutils.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client extends BaseEntity {
    private String firstName;

    private String lastName;

    private String clientContact;

    private String clientEmail;

    private Enum Gender;

    @Column(name="client_contact")
    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }
    @Column(name="client_email")
    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Column(name="client_first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="client_last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "client-gender")
    public Enum getGender() {
        return Gender;
    }

    public void setGender(Enum gender) {
        Gender = gender;
    }
}
