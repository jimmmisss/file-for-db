package br.com.file.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nomeContact;
    private Integer ageContact;
    private BigDecimal incomeContact;
    private LocalDateTime dateInsertionContact = LocalDateTime.now();

    public Contact() {
    }

    public Contact(String nomeContact, Integer ageContact, BigDecimal incomeContact, LocalDateTime dateInsertionContact) {
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

    public Integer getAgeContact() {
        return ageContact;
    }

    public void setAgeContact(Integer ageContact) {
        this.ageContact = ageContact;
    }

    public BigDecimal getIncomeContact() {
        return incomeContact;
    }

    public void setIncomeContact(BigDecimal incomeContact) {
        this.incomeContact = incomeContact;
    }

    public LocalDateTime getDateInsertionContact() {
        return dateInsertionContact;
    }

    public void setDateInsertionContact(LocalDateTime dateInsertionContact) {
        this.dateInsertionContact = dateInsertionContact;
    }
}
