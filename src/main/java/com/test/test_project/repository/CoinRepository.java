package com.test.test_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.test_project.entity.Coin;
import com.test.test_project.entity.CoinData;


@Repository
public interface CoinRepository extends JpaRepository<Coin,Integer>{
	@Query(value = "SELECT * FROM Coin, WHERE coin = :coin",
			nativeQuery = true)
	List<Coin> findByCoin(@Param("coin") String coin);
	
	@Query(value = "SELECT b.chineseName,a.* FROM Coin a join coinname b on a.coin=b.coin WHERE a.coin = :coin",
			nativeQuery = true)
	String findDataByCoin(@Param("coin") String coin);
	
	@Query(value = "SELECT new com.test.test_project.entity.CoinData(a.coin,b.chineseName,a.rate_float,a.updateTime) FROM Coin a inner join CoinChineseName b on a.coin=b.coin where a.coin = :coin")
	List<CoinData> findByCoin2(@Param("coin") String coin);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Coin WHERE coin = :coin")
	Integer deleteByCoin(@Param("coin") String coin);
}
