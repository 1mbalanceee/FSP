package com.politech.fsptenders;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class DocxTextExtractor {
    public static void main(String[] args) throws IOException {
        // Путь к вашему файлу .docx
        String filePath = "path/to/your/document.docx";

        // Создание объекта FileInputStream для чтения файла
        FileInputStream fis = new FileInputStream(filePath);

        // Создание объекта XWPFDocument
        XWPFDocument document = new XWPFDocument(fis);

        // Получение объекта CTBody из документа
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody body = document.getDocument().getBody();

        // Получение списка абзацев из CTBody
        List<XWPFParagraph> paragraphs = document.getParagraphs();

        // Перебор абзацев и вывод текста
        for (XWPFParagraph paragraph : paragraphs) {
            System.out.println(paragraph.getText());
        }

        // Закрытие потока FileInputStream
        fis.close();
    }
}
