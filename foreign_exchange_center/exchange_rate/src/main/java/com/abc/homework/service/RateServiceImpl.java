package com.abc.homework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.homework.model.RateRepository.ExchangeRate;
import com.abc.homework.model.RateRepository.RateRepository_JPA;

 	
@Service
public class RateServiceImpl implements RateService{
    private RateRepository_JPA rateRepository;

    public RateServiceImpl(RateRepository_JPA rateRepository) {
        this.rateRepository = rateRepository;
    }

    //query one
	@Override
	public ExchangeRate getRateById(Long id) {
		return rateRepository.findById(id).get();
	}

	//query all
	@Override
	public List<ExchangeRate> findAllRates() {
		return rateRepository.findAll();
	}

	
	@Override
	public ExchangeRate saveRate(ExchangeRate Rate) {
		return rateRepository.save(Rate);
	}

	@Override
	public ExchangeRate updateRate(ExchangeRate Rate) {
		 return rateRepository.save(Rate);
	}

	@Override
	public void deleteRate(Long id) {
		rateRepository.deleteById(id);
	}

	@Override
	public void deleteAllRate() {
		rateRepository.deleteAll();		
	}

	@Override
	public void addExchangeRateRecord(ExchangeRate exchangeRate) {
		// TODO Auto-generated method stub
		
	}
}
   