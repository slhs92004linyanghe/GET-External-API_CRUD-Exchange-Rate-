package com.yushunbank.foreignexchangecenter.service;

import java.util.List;

import com.yushunbank.foreignexchangecenter.model.Employee;
import com.yushunbank.foreignexchangecenter.model.ForeignExchangeRate;

public interface RateService {
	void saveTaifexRateOneByOne();
	ForeignExchangeRate saveRate(ForeignExchangeRate foreignExchangeRate);
	List<ForeignExchangeRate> getAllRates();
	ForeignExchangeRate getRateById(long id);
	ForeignExchangeRate updateRate(ForeignExchangeRate foreignExchangeRate, long id);
	void deleteRate(long id);
	List<ForeignExchangeRate> getAllTaifexRates();
    }

