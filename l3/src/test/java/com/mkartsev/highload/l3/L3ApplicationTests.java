package com.mkartsev.highload.l3;

import com.mkartsev.highload.l3.service.ExchangeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class L3ApplicationTests {

	@Autowired
	ExchangeService exchangeService;

	@Test
	void contextLoads() {
		System.out.println(exchangeService.getExchangeRateList());
	}

}
