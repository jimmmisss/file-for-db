package br.com.file.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "file_lucky_number")
public class File implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String idNumberFile;
    private String numberFile;
    private LocalDateTime dateInsertionFile = LocalDateTime.now();

    public File() {
        super();
    }

    public File(String idNumberFile, String numberFile, LocalDateTime dateInsertionFile) {
        this.idNumberFile = idNumberFile;
        this.numberFile = numberFile;
        this.dateInsertionFile = dateInsertionFile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdNumberFile() {
        return idNumberFile;
    }

    public void setIdNumberFile(String idNumberFile) {
        this.idNumberFile = idNumberFile;
    }

    public String getNumberFile() {
        return numberFile;
    }

    public void setNumberFile(String numberFile) {
        this.numberFile = numberFile;
    }

    public LocalDateTime getDateInsertionFile() {
        return dateInsertionFile;
    }

    public void setDateInsertionFile(LocalDateTime dateInsertionFile) {
        this.dateInsertionFile = dateInsertionFile;
    }
}