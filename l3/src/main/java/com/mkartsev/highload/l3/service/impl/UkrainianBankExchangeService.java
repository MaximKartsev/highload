package com.mkartsev.highload.l3.service.impl;

import com.mkartsev.highload.l3.model.Currency;
import com.mkartsev.highload.l3.model.ExchangeRate;
import com.mkartsev.highload.l3.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UkrainianBankExchangeService implements ExchangeService {
    private final static String URI = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    private final RestTemplate restTemplate;

    @Autowired
    public UkrainianBankExchangeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ExchangeRate getExchangeRate(Currency currency) {
        List<ExchangeRate> exchangeRateList = getExchangeRateList();
        return exchangeRateList.stream()
                .filter(rate -> Objects.equals(rate.getAbbreviation(), currency.name()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Currency does not exists"));
    }

    @Override
    public List<ExchangeRate> getExchangeRateList() {
        ExchangeRate[] forObject = restTemplate.getForObject(URI, ExchangeRate[].class);
        return forObject == null ? new ArrayList<>() : Arrays.asList(forObject);
    }
}
