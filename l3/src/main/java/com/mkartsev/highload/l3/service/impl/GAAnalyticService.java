package com.mkartsev.highload.l3.service.impl;

import com.mkartsev.highload.l3.model.ExchangeRate;
import com.mkartsev.highload.l3.service.AnalyticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class GAAnalyticService implements AnalyticService {
    private final static String URI = "https://google-analytics.com/collect?v=1&tid=%s&cid=555&t=event&ec=Currency&ea=exchange&el=%s";

    private final RestTemplate restTemplate;
    private final String tId;

    @Autowired
    public GAAnalyticService(Environment environment,
                             RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        tId = environment.getProperty("tid");
    }

    @Override
    public void pushEvent(String exchangeRate) {
        String url = String.format(URI, tId, exchangeRate);
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "test-agent/1.2.3");
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        log.info(response.getBody());
    }
}
