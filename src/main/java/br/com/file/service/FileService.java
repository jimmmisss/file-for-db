package br.com.file.service;

import br.com.file.entity.File;
import br.com.file.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Scanner;

@Service
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void save(String filename) throws IOException {

        Scanner scanner = new Scanner(new java.io.File(filename));

        while(scanner.hasNextLine()) {

            String line = scanner.nextLine();
            Scanner scannerLine = new Scanner(line);
            String identifier = scannerLine.next();
            String number = scannerLine.next();

            File file = new File();

            if(identifier.isEmpty() || number.isEmpty()) {
                file.setIdNumberFile(identifier);
                file.setNumberFile(number);
                fileRepository.save(file);
            }

            scannerLine.close();
        }

        scanner.close();
    }

}
