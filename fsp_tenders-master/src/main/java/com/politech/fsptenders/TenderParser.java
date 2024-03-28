package com.politech.fsptenders;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class TenderParser {

    public static void main(String[] args) {
        String tenderUrl = "https://example.com/tender"; // Замените на URL страницы извещения

        try {
            // Выполнение HTTP-запроса и получение HTML-кода страницы
            Document document = Jsoup.connect(tenderUrl).get();

            // Извлечение всех элементов <p> на странице
            Elements paragraphs = document.select("p");

            // Вывод текста каждого элемента <p>
            for (Element paragraph : paragraphs) {
                System.out.println(paragraph.text());
            }

            // Извлечение других элементов и данных по необходимости

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
