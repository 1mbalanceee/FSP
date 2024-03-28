package com.politech.fsptenders;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.*;

public class DocumentParser {

    public static void main(String[] args) {
        String filePath = "example.docx"; // Путь к файлу документации

        // Определяем тип файла и вызываем соответствующий метод парсинга
        if (filePath.endsWith(".docx")) {
            parseDocx(filePath);
        } else if (filePath.endsWith(".doc")) {
            parseDoc(filePath);
        } else if (filePath.endsWith(".xlsx")) {
            parseXlsx(filePath);
        } else if (filePath.endsWith(".xls")) {
            parseXls(filePath);
        } else {
            System.out.println("Неподдерживаемый формат файла.");
        }
    }

    // Метод для парсинга документа в формате docx
    private static void parseDocx(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            XWPFDocument document = new XWPFDocument(fis);
            // Извлекаем текст из документа
            String text = getTextFromDocx(document);
            System.out.println(text);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для извлечения текста из документа docx
    private static String getTextFromDocx(XWPFDocument doc) {
        StringBuilder sb = new StringBuilder();
        for (XWPFParagraph p : doc.getParagraphs()) {
            sb.append(p.getText()).append("\n");
        }
        return sb.toString();
    }

    // Метод для парсинга документа в формате doc
    private static void parseDoc(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            WordExtractor extractor = new WordExtractor(fis);
            // Извлекаем текст из документа
            String text = extractor.getText();
            System.out.println(text);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для парсинга документа в формате xlsx
    private static void parseXlsx(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fis);
            // Обрабатываем каждый лист в книге
            processWorkbook(workbook);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для парсинга документа в формате xls
    private static void parseXls(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = new HSSFWorkbook(fis);
            // Обрабатываем каждый лист в книге
            processWorkbook(workbook);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Обработка книги (для xls и xlsx)
    private static void processWorkbook(Workbook workbook) {
        // Обрабатываем каждый лист в книге
        for (Sheet sheet : workbook) {
            // Обрабатываем каждую строку в листе
            for (Row row : sheet) {
                // Обрабатываем каждую ячейку в строке
                for (Cell cell : row) {
                    // Извлекаем текст из ячейки и выводим его
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }
        }
    }
}
