package com.abc.homework.model.RateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RateRepository_JDBC {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addExchangeRateRecord(ExchangeRate exchangeRate) {
		System.out.println("EXCUTE INSERT RECORD");
		jdbcTemplate.update(
				"INSERT INTO foreign_exchange_center.exchangerate( date, usdToNtd, rmbToNtd, usdToRmb, CREATE_DATE) "
						+ "VALUES (NOW(),?,?,?,NOW())",
				exchangeRate.getUsdToNtd(), exchangeRate.getRmbToNtd(), exchangeRate.getUsdToRmb());
	}

}
