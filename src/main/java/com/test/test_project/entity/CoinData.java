package com.test.test_project.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

public class CoinData {

	private String coin;
	
	private String chineseName;
	
	private String rate_float;
	
	private Timestamp updateTime;
	
	public static Timestamp sdFormat(String strDate) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdFormat.parse(strDate));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Timestamp(calendar.getTimeInMillis());	
	}
	
	public CoinData() {}
	
	/**
	 * @param coin
	 * @param chineseName
	 * @param rate_float
	 * @param updateTime
	 */
	public CoinData(String coin, String chineseName, String rate_float, Object updateTime) {
		this.coin = coin;
		this.chineseName = chineseName;
		this.rate_float = rate_float;
		this.updateTime = sdFormat(updateTime.toString());
	}

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getRate_float() {
		return rate_float;
	}

	public void setRate_float(String rate_float) {
		this.rate_float = rate_float;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "CoinData [coin=" + coin + ", chineseName=" + chineseName + ", rate_float=" + rate_float
				+ ", updateTime=" + updateTime + "]";
	}
	
}
