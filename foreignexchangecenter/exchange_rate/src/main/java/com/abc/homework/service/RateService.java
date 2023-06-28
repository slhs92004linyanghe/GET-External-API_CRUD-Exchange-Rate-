package com.abc.homework.service;

import java.util.List;

import com.abc.homework.model.RateRepository.ExchangeRate;

public interface RateService {
	void addExchangeRateRecord(ExchangeRate exchangeRate);

	ExchangeRate getRateById(Long id);

	List<ExchangeRate> findAllRates();

	ExchangeRate saveRate(ExchangeRate Rate);

	ExchangeRate updateRate(ExchangeRate Rate);

	void deleteRate(Long id);

	void deleteAllRate();

}
