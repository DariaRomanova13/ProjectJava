package edu.nmu.fit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelController {

    @GetMapping("/getExcel")
    public void getExcel(@RequestParam String searchTerm) {



    }

}
