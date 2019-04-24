package br.com.file.controller;

import br.com.file.entity.Contact;
import br.com.file.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/generate")
    public void writerContactFile() throws IOException {
        String filename = "/home/rita/Documents/ZURICH.txt";
        contactService.writerContactFile(filename);
    }

    @GetMapping("/generate-xls")
    public void writerContactFileXlx() throws IOException {
        String filename = "/home/rita/Documents/contact.xlsx";
        contactService.writerContactFileXlx(filename);
    }

    @PostMapping("/saveTxt-contact")
    public ResponseEntity<?> save(Contact contact) {
        return ResponseEntity.ok(contactService.save(contact));
    }
}