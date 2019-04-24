package br.com.file.controller;

import br.com.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    @Autowired
    FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/generate")
    public void save() throws IOException {
        String filename = "/home/rita/Downloads/RTPD0001019741010201.txt";
        fileService.saveTxt(filename);
    }
}
