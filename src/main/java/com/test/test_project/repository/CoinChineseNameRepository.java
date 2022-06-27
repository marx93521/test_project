package com.test.test_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.test_project.entity.CoinChineseName;

@Repository
public interface CoinChineseNameRepository extends JpaRepository<CoinChineseName,Integer>{
	@Query(value = "SELECT * FROM coinname WHERE coin = :coin",
			nativeQuery = true)
	CoinChineseName findByCoin(@Param("coin") String coin);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM CoinChineseName WHERE coin = :coin")
	Integer deleteByCoin(@Param("coin") String coin);
}
