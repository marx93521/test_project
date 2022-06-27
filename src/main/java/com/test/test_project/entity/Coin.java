package com.test.test_project.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="coin")
public class Coin {
	@Id
	@Column(name="coin")
	String coin;
	
	@Column(name="rate_float")
	String rate_float;
	
	@Column(name="updateTime")
	Timestamp updateTime;
	
	@OneToOne
	@JoinColumn(name="coin")
	private CoinChineseName CoinChineseName;
	
	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
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
		return "Coin [coin=" + coin + ", rate_float=" + rate_float + ", updateTime=" + updateTime
				+ ", coin_chineseName="  + "]";
	}  
	
}
