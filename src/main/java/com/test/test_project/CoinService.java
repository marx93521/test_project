package com.test.test_project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test_project.entity.Coin;
import com.test.test_project.entity.CoinData;
import com.test.test_project.repository.CoinRepository;

@Service
public class CoinService {
	
	@Autowired
	private CoinRepository coinRepository;

	//取得資料 by Coin
	public List<Coin> findByCoin(String coin) {
		return coinRepository.findByCoin(coin);
	}
	
	//取得join資料 by Coin
	public String findDataByCoin(String coin) {
		return coinRepository.findDataByCoin(coin);
	}
	//取得coinData資料 
	public List<CoinData> findCoinData(String coinType) {
		return coinRepository.findByCoin2(coinType);
	}
	
	//新增修改
	public void saveOrUpdate(Coin coin)	{  
		coinRepository.save(coin);  
	}
	
	//刪除byCoin
	public void deleta(String coin)	{  
		coinRepository.deleteByCoin(coin);  
	} 
}
