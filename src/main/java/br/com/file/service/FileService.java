package br.com.file.service;

import br.com.file.entity.File;
import br.com.file.repository.FileRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

@Service
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void saveTxt(String filename) throws IOException {

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

    public void saveExcel(String filename) throws IOException {

        FileInputStream input = new FileInputStream(new java.io.File(filename));

        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> iterator = (Iterator<Row>) sheet.iterator();

        while(iterator.hasNext()) {
            Row currentRow = iterator.next();
            Iterator<Cell> cell = currentRow.iterator();

            while(cell.hasNext()) {
                Cell currentCell = cell.next();

                if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) {
                    System.out.println(currentCell.getStringCellValue());
                }
                if (currentCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    System.out.println(currentCell.getNumericCellValue() + "");
                }
            }
        }

    }

}
