package com.green.userservice.lotto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@RestController
@RequestMapping("/lotto")
public class LottoController {

    @GetMapping("/maxMumber")
    public static int getMaxNumber() throws Exception {
        String url = "https://dhlottery.co.kr/common.do?method=main";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        Document document = Jsoup.parse(response.toString());
        Element maxNumbElement = document.selectFirst("strong#lottoDrwNo");

        return Integer.parseInt(maxNumbElement.text());
    }
}
