package com.test.test_project;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.test_project.entity.Coin;
import com.test.test_project.entity.CoinData;
import com.test.test_project.entity.Coindesk;

@RestController  
public class CoinControl {
	@Autowired
	CoinService coinService;
	@Autowired
	CoinDataService coinDataService;
	
	@GetMapping("/query/{coin}")
	private List<CoinData> getCoinData(@PathVariable("coin") String coin) {
		
		String data = "";
//		String coinData = coinService.findDataByCoin(coin);
//		List<Coin> listCoin = coinService.findByCoin(coin);
		
		List<CoinData> CoinData = coinService.findCoinData(coin);
		for(int i=0;i<CoinData.size();i++) {
//			data = data + "\n " +CoinData.get(i).toString();
		}
//		data = coinData.toString();
		return CoinData;
		
	}
	
	@GetMapping("/query2/{coin}")
	private String getDataByCoin(@PathVariable("coin") String coin) {
		
		String data = "";
		String coinData = coinService.findDataByCoin(coin);

		return coinData;
		
	}
	
	@GetMapping("/saveAPI")
	private String saveAPI() {
		GetCoindesk getCoindesk = new GetCoindesk();
		Coindesk coindesk = getCoindesk.GetCoindeskInfo();
		Coin coinEntity = new Coin();
		Map<String, Map<String, String>> BpiMap = coindesk.getBpi();
		
		BpiMap.forEach((key,value) -> {
			coinEntity.setCoin(value.get("code"));
			coinEntity.setRate_float(value.get("rate_float"));
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date now = new Date(System.currentTimeMillis());
			coinEntity.setUpdateTime(new Timestamp(now.getTime()));
			coinService.saveOrUpdate(coinEntity);
		});
		
		return "done";
	}
}
