package br.com.file.service;

import br.com.file.entity.Contact;
import br.com.file.repository.ContactRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void writerContactFile(String filename) throws IOException {

        List<Contact> contact = contactRepository.findAll();
        PrintWriter pw = new PrintWriter(new File(filename));

        pw.println("================== VENDA DE SEGUROS - CALCARD/ZURICH ==================");
        for (Contact c: contact) {
            pw.printf("%-20s\t", c.getNomeContact());
            pw.printf("%5d\t", c.getAgeContact());
            pw.printf("%-10.2f\t", c.getIncomeContact());
            pw.println(c.getDateInsertionContact());
        }
        pw.println("============================= FIM DA LISTA ============================");
        pw.close();
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public void writerContactFileXlx(String filename) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet 1");

        List<Contact> contacts = contactRepository.findAll();

        String[] info = {"ID", "Name", "Age", "Income"};

        int rows = 0;
        for(Contact c : contacts) {
            Row row = sheet.createRow(rows++);
            int cellnum = 0;
            Cell id = row.createCell(cellnum++);
            id.setCellValue(c.getId());
            Cell name = row.createCell(cellnum++);
            name.setCellValue(c.getNomeContact());
            Cell age = row.createCell(cellnum++);
            age.setCellValue(c.getAgeContact());
            Cell income = row.createCell(cellnum++);
            income.setCellValue(String.valueOf(c.getIncomeContact()));
        }

        FileOutputStream pw = new FileOutputStream(new File(filename));
        workbook.write(pw);
        pw.close();
        System.out.println("Created");

    }
}