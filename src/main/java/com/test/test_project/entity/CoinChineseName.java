package com.test.test_project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="coinname")
public class CoinChineseName {
	@Id
	@Column(name="coin")
	String coin;
	
	@Column(name="name")
	String chineseName;
	
	@OneToOne
	@JoinColumn(name="coin")
	private Coin coinEntity;
	
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

}
