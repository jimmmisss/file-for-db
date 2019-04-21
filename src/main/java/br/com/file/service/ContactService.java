package br.com.file.service;

import br.com.file.entity.Contact;
import br.com.file.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void writerContactFile() throws IOException {

        List<Contact> contact = contactRepository.findAll();
        PrintWriter pw = new PrintWriter(new File("/home/rita/Documents/ZURICH.txt"));

        for (Contact c: contact) {
            pw.printf("%s\t", c.getNomeContact());
            pw.printf("%d\t", c.getAgeContact());
            pw.printf("%.2f\t", c.getIncomeContact());
            pw.println(c.getDateInsertionContact());
        }

        pw.close();
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
}
