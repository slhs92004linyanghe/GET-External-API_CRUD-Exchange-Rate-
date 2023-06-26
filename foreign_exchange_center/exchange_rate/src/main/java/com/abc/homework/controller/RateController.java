package com.abc.homework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.homework.model.RateRepository.ExchangeRate;
import com.abc.homework.service.RateService;
import com.abc.homework.service.RateServiceImpl;
import com.abc.homework.service.RateServiceImpl_JDBC;

@RestController
@RequestMapping("/rates")
public class RateController {
	private final Logger logger = LoggerFactory.getLogger(RateController.class);

	@Autowired
	RateServiceImpl_JDBC rateServiceImpl_JDBC;
//	@Autowired
//	private RateService rateService;

//	public RateController(RateService rateService) {
//		this.rateService = rateService;
//	}


	@Autowired
	ExchangeRate exchangeRate;


	@RequestMapping("/addExchangeRateRecord")
	public String hello() {
		exchangeRate = new ExchangeRate();
		exchangeRate.setUsdToNtd("1");
		exchangeRate.setRmbToNtd("2");
		exchangeRate.setUsdToRmb("3");
		rateServiceImpl_JDBC.addExchangeRateRecord(exchangeRate);
		return "New Record added";
	}

}

//	@GetMapping("/{id}")
//    public String getRate(@PathVariable Long id, Model model) {
//        ExchangeRate rate = rateService.getRateById(id);
//        model.addAttribute("rate", rate);
//        return "rate";
//    }
//	
//	
//	@GetMapping("/findAll")
//    public String getRateAll(Model model) {
//         List<ExchangeRate> findAll = rateService.findAllRates();
//        model.addAttribute("findAll", findAll);
//        return "findAll";
//    }
