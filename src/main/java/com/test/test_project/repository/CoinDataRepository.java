package com.test.test_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.test.test_project.entity.Coin;
import com.test.test_project.entity.CoinData;

public interface CoinDataRepository{
//	@Query(value = "SELECT b.chineseName,a.* FROM Coin a join Coin_chineseName b on a.coin=b.coin WHERE a.Coin = :coin",
//			nativeQuery = true)
//	CoinData findByCoin(@Param("coin") String coin);
}
