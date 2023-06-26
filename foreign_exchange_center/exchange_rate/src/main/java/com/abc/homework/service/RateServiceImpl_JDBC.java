package com.abc.homework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.homework.model.RateRepository.ExchangeRate;
import com.abc.homework.model.RateRepository.RateRepository_JDBC;

@Service
public class RateServiceImpl_JDBC implements RateService {

	@Autowired
	RateRepository_JDBC rateRepository_JDBC;

	@Override
	public void addExchangeRateRecord(ExchangeRate exchangeRate) {
		rateRepository_JDBC.addExchangeRateRecord(exchangeRate);
	}

	@Override
	public ExchangeRate getRateById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExchangeRate> findAllRates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExchangeRate saveRate(ExchangeRate Rate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExchangeRate updateRate(ExchangeRate Rate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRate(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllRate() {
		// TODO Auto-generated method stub

	}

}
