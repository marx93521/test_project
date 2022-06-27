package com.test.test_project;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.test_project.entity.Coin;
import com.test.test_project.entity.Coindesk;
import com.test.test_project.repository.CoinRepository;

public class ParseCoin {
	@Autowired
	CoinService coinService;
	Coindesk coindesk;
	String coin;
	String rate_float;
	
	public void ParseData(Coindesk coindesk) {
		Coin coinEntity = new Coin();
		Map<String,String> timeMap = coindesk.getTime();
		Map<String, Map<String, String>> BpiMap = coindesk.getBpi();
		
		BpiMap.forEach((key,value) -> {
			coinEntity.setCoin(value.get("code"));
			coinEntity.setRate_float(value.get("rate_float"));
			//coinEntity.setUpdateTime(new Date(System.currentTimeMillis()));
			coinService.saveOrUpdate(coinEntity);
		});
	}
	
}
