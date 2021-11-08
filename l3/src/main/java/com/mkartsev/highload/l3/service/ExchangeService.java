package com.mkartsev.highload.l3.service;

import com.mkartsev.highload.l3.model.Currency;
import com.mkartsev.highload.l3.model.ExchangeRate;

import java.util.List;

public interface ExchangeService {
    ExchangeRate getExchangeRate(Currency currency);

    List<ExchangeRate> getExchangeRateList();
}
