package com.politech.fsptenders;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TenderSearcher {

    public static void main(String[] args) {
        searchTendersOnTatneft("Наименование");
        searchTendersOnTenderPro("ваш_ключевой_слово");
        searchTendersOnIceTrade("ваш_ключевой_слово");
    }

    private static void searchTendersOnTatneft(String keyword) {
        String url = "https://etp.tatneft.ru/search?q=" + keyword;
        searchTenders(url, "Tatneft");
    }

    private static void searchTendersOnTenderPro(String keyword) {
        String url = "https://tender.pro/search?q=" + keyword;
        searchTenders(url, "TenderPro");
    }

    private static void searchTendersOnIceTrade(String keyword) {
        String url = "https://icetrade.by/search?q=" + keyword;
        searchTenders(url, "IceTrade");
    }

    private static void searchTenders(String url, String siteName) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements tenderElements = doc.select("div.tender-item");

            for (Element tenderElement : tenderElements) {
                String tenderCode = tenderElement.select("div.tender-item__code").text();
                String tenderTitle = tenderElement.select("a.tender-item__link").text();
                String tenderStatus = tenderElement.select("div.tender-item__status").text();
                String tenderCustomer = tenderElement.select("div.tender-item__customer").text();
                String tenderPrice = tenderElement.select("div.tender-item__price").text();
                String tenderCurrency = tenderElement.select("div.tender-item__currency").text();
                String tenderPublishDate = tenderElement.select("div.tender-item__published").text();
                String tenderStartDate = tenderElement.select("div.tender-item__start-date").text();
                String tenderEndDate = tenderElement.select("div.tender-item__end-date").text();

                System.out.println("Site: " + siteName);
                System.out.println("Code: " + tenderCode);
                System.out.println("Title: " + tenderTitle);
                System.out.println("Status: " + tenderStatus);
                System.out.println("Customer: " + tenderCustomer);
                System.out.println("Price: " + tenderPrice);
                System.out.println("Currency: " + tenderCurrency);
                System.out.println("Publish Date: " + tenderPublishDate);
                System.out.println("Start Date: " + tenderStartDate);
                System.out.println("End Date: " + tenderEndDate);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
