package br.com.file.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "file_lucky_number", schema = "file")
public class File implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String idNumberFile;
    private String numberFile;
    public File() {
        super();
    }

    public File(String idNumberFile, String numberFile) {
        this.idNumberFile = idNumberFile;
        this.numberFile = numberFile;
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

}