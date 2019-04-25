package br.com.file.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nomeContact;
    private String ageContact;
    private String incomeContact;
    private String dateInsertionContact;

    public Contact() {
    }

    public Contact(String nomeContact, String ageContact, String incomeContact, String dateInsertionContact) {
        this.nomeContact = nomeContact;
        this.ageContact = ageContact;
        this.incomeContact = incomeContact;
        this.dateInsertionContact = dateInsertionContact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeContact() {
        return nomeContact;
    }

    public void setNomeContact(String nomeContact) {
        this.nomeContact = nomeContact;
    }

    public String getAgeContact() {
        return ageContact;
    }

    public void setAgeContact(String ageContact) {
        this.ageContact = ageContact;
    }

    public String getIncomeContact() {
        return incomeContact;
    }

    public void setIncomeContact(String incomeContact) {
        this.incomeContact = incomeContact;
    }

    public String getDateInsertionContact() {
        return dateInsertionContact;
    }

    public void setDateInsertionContact(String dateInsertionContact) {
        this.dateInsertionContact = dateInsertionContact;
    }
}
