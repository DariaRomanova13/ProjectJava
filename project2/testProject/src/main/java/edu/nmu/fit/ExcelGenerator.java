package edu.nmu.fit;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ExcelGenerator {
        public static void generateExcel(String searchTerm, String website) throws IOException {
            // Завантаження сторінки сайту
            String url = null;
            if (website.equals("olx")) {
                url = "https://www.olx.ua/";
            } else if (website.equals("rozetka")) {
                url = "https://rozetka.com.ua/";
            } else if (website.equals("epicentr")) {
                url = "https://epicentrk.ua/";
            }
            Document doc = Jsoup.connect(url).data("q", searchTerm).get();

            // Пошук всіх об'яв на сторінці
            Elements ads = null;
            if (website.equals("olx")) {
                ads = doc.select(".offer-wrapper");
            } else if (website.equals("rozetka")) {
                ads = doc.select(".goods-tile__inner");
            } else if (website.equals("epicentr")) {
                ads = doc.select(".product-card");
            }

            // Створення Excel файлу та аркуша
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Результати пошуку");

            // Створення заголовків колонок
            Row headerRow = sheet.createRow(0);
            Cell linkCell = headerRow.createCell(0);
            linkCell.setCellValue("Посилання на товар");
            Cell numberCell = headerRow.createCell(1);
            numberCell.setCellValue("Внутрішній номер товару на сайті");
            Cell urlCell = headerRow.createCell(2);
            urlCell.setCellValue("Лінка на товар на сайті");
            Cell descriptionCell = headerRow.createCell(3);
            descriptionCell.setCellValue("Короткий опис");
            Cell priceCell = headerRow.createCell(4);
            priceCell.setCellValue("Ціна");
            sheet.autoSizeColumn(1);

            // Запис результатів у файл
            int rowNumber = 1;
            for (Element ad : ads) {
                Row row = sheet.createRow(rowNumber++);
                Cell adLinkCell = row.createCell(0);


            }

            // Збереження файлу
            String fileName = "search_results.xlsx";
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            workbook.close();
        }
    }


