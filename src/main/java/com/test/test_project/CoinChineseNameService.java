package com.test.test_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test_project.entity.CoinChineseName;
import com.test.test_project.repository.CoinChineseNameRepository;

@Service
public class CoinChineseNameService {
	@Autowired
	private CoinChineseNameRepository coinChineseNameRepository;
	
	//取得資料 by Coin
	public CoinChineseName findByCoin(String coin) {
		return coinChineseNameRepository.findByCoin(coin);
	}
		
	//新增修改
	public void saveOrUpdate(CoinChineseName Coin_chineseName)	{  
		coinChineseNameRepository.save(Coin_chineseName);  
	}
		
	//刪除byCoin
	public void deleta(String coin)	{  
		coinChineseNameRepository.deleteByCoin(coin);  
	} 
}
