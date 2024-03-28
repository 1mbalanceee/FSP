package com.politech.fsptenders;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyPositionsExtractor {

    public static void main(String[] args) {
        String text = "Продукт: Труба\n" +
                "Размеры: 100x100 мм\n" +
                "Марка стали: AISI 304\n" +
                "Стандарт: ASTM A312\n" +
                "Класс прочности: 316L";

        extractKeyPositions(text);
    }

    public static void extractKeyPositions(String text) {
        String[] keywords = {"Продукт", "Размеры", "Марка стали", "Стандарт", "Класс прочности"};

        for (String keyword : keywords) {
            String regex = keyword + ":\\s*(.+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                String keyPosition = matcher.group(1);
                System.out.println(keyword + ": " + keyPosition);
            } else {
                System.out.println(keyword + " не найден.");
            }
        }
    }
}
