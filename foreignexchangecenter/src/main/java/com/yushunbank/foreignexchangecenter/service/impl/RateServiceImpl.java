package com.yushunbank.foreignexchangecenter.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yushunbank.foreignexchangecenter.exception.ResourceNotFoundException;
import com.yushunbank.foreignexchangecenter.model.ForeignExchangeRate;
import com.yushunbank.foreignexchangecenter.repository.ForeignExchangeRateRepository;
import com.yushunbank.foreignexchangecenter.service.RateService;

//使用JPA來CRUD故省略@Transactional
@Service
public class RateServiceImpl implements RateService {

	private ForeignExchangeRateRepository foreignExchangeRateRepository;

	// 可省略@Autowired注入因只有一個建構子的情況SPRING會自動注入
	public RateServiceImpl(ForeignExchangeRateRepository foreignExchangeRateRepository) {
		super();
		this.foreignExchangeRateRepository = foreignExchangeRateRepository;
	}

	@Override
	public ForeignExchangeRate saveRate(ForeignExchangeRate foreignExchangeRate) {
		return foreignExchangeRateRepository.save(foreignExchangeRate);
	}

	@Override
	public List<ForeignExchangeRate> getAllRates() {
		return foreignExchangeRateRepository.findAll();
	}

	@Override
	public ForeignExchangeRate getRateById(long id) {
		return foreignExchangeRateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Rate", "Id", id));
	}

	@Override
	public ForeignExchangeRate updateRate(ForeignExchangeRate foreignExchangeRate, long id) {

		// we need to check whether employee with gived id is exist in DB or not
		ForeignExchangeRate existingForeignExchangeRate = foreignExchangeRateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Rate", "Id", id));
		existingForeignExchangeRate.setDate(foreignExchangeRate.getDate());
		existingForeignExchangeRate.setUsdToNtd(foreignExchangeRate.getUsdToNtd());
		existingForeignExchangeRate.setRmbToNtd(foreignExchangeRate.getRmbToNtd());
		existingForeignExchangeRate.setUsdToRmb(foreignExchangeRate.getUsdToRmb());
		// save existing employee to DB
		foreignExchangeRateRepository.save(existingForeignExchangeRate);
		return existingForeignExchangeRate;
	}

	@Override
	public void deleteRate(long id) {
		// check whether a employee exist in a DB or not
		foreignExchangeRateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rate", "Id", id));

		foreignExchangeRateRepository.deleteById(id);
	}

	@Override
	public void saveTaifexRateOneByOne() {
		String apiUrl = "https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
		if (response.getStatusCode().is2xxSuccessful()) {
			String responseBody = response.getBody();
			System.out.println(responseBody);
			ObjectMapper mapper1 = new ObjectMapper();
			try {
				JsonNode jsonNode = mapper1
//						.readTree("[{ \"Date\":\"20230502\",\"USD/NTD\":\"30.782\",\"RMB/NTD\":\"4.426698\" },"
//								+ "{ \"Date\":\"20230502\",\"USD/NTD\":\"30.782\",\"RMB/NTD\":\"4.426698\" }]");
						.readTree(responseBody);
				System.out.println("存入TAIFEX筆數" + jsonNode.size());
				for (JsonNode element : jsonNode) {
					String date = element.get("Date").asText();
					String usdToNtd = element.get("USD/NTD").asText();
					String rmbToNtd = element.get("RMB/NTD").asText();
					String usdToRmb = element.get("USD/RMB").asText();
					// 创建新的响应体对象
					ForeignExchangeRate foreignExchangeRate = new ForeignExchangeRate();
					foreignExchangeRate.setDate(date);
					foreignExchangeRate.setUsdToNtd(usdToNtd);
					foreignExchangeRate.setRmbToNtd(rmbToNtd);
					foreignExchangeRate.setUsdToRmb(usdToRmb);
					foreignExchangeRateRepository.save(foreignExchangeRate);
					System.out.println(foreignExchangeRate);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
//		foreignExchangeRateRepository.saveAll(newJsonResponse);

		}
	}

	@Override
	public List<ForeignExchangeRate> getAllTaifexRates() {
		String apiUrl = "https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
		if (response.getStatusCode().is2xxSuccessful()) {
			String responseBody = response.getBody();
			System.out.println(responseBody);
			ObjectMapper mapper1 = new ObjectMapper();
			JsonNode jsonNode;
			try {
				jsonNode = mapper1.readTree(responseBody);
				List<ForeignExchangeRate> foreignExchangeRates = new ArrayList<>();

				for (JsonNode element : jsonNode) {
					String date = element.get("Date").asText();
					String usdToNtd = element.get("USD/NTD").asText();
					String rmbToNtd = element.get("RMB/NTD").asText();
					String usdToRmb = element.get("USD/RMB").asText();
					ForeignExchangeRate foreignExchangeRate = new ForeignExchangeRate(); // 根据实际情况创建 Employee 对象
					foreignExchangeRate.setDate(date);
					foreignExchangeRate.setUsdToNtd(usdToNtd);
					foreignExchangeRate.setRmbToNtd(rmbToNtd);
					foreignExchangeRate.setUsdToRmb(usdToRmb);
					
					foreignExchangeRates.add(foreignExchangeRate);
					System.out.println(foreignExchangeRate.toString());
					System.out.println("Number of foreignExchangeRates: " + foreignExchangeRates.size());
				}
				foreignExchangeRateRepository.saveAll(foreignExchangeRates);
				
				return 	 foreignExchangeRates;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Collections.emptyList();
	}
}
