package com.mkartsev.highload.l3;

import com.mkartsev.highload.l3.model.Currency;
import com.mkartsev.highload.l3.model.ExchangeRate;
import com.mkartsev.highload.l3.service.AnalyticService;
import com.mkartsev.highload.l3.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class L3Application {

	public static void main(String[] args) {
		SpringApplication.run(L3Application.class, args);
	}

	private final AnalyticService analyticService;
	private final ExchangeService exchangeService;

	@Autowired
	public L3Application(AnalyticService analyticService, ExchangeService exchangeService) {
		this.analyticService = analyticService;
		this.exchangeService = exchangeService;
	}

	@Scheduled(fixedRate = 120000)
	public void reportCurrentTime() {
		ExchangeRate exchangeRate = exchangeService.getExchangeRate(Currency.USD);
		analyticService.pushEvent(exchangeRate.getRate());
	}
}
