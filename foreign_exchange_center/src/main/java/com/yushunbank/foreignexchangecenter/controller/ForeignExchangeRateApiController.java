package com.yushunbank.foreignexchangecenter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yushunbank.foreignexchangecenter.model.Employee;
import com.yushunbank.foreignexchangecenter.model.ForeignExchangeRate;
import com.yushunbank.foreignexchangecenter.service.RateService;

@RestController
@RequestMapping("/api/rates")
public class ForeignExchangeRateApiController {
	private RateService rateService;

	public ForeignExchangeRateApiController(RateService rateService) {
		super();
		this.rateService = rateService;
	}
	
	
	
	// build create employee REST API
	// [POST]http://localhoast:8888/api/rates +body value
	@PostMapping()
	public ResponseEntity<ForeignExchangeRate> saveEmployee(@RequestBody ForeignExchangeRate foreignExchangeRate) {
		return new ResponseEntity<ForeignExchangeRate>(rateService.saveRate(foreignExchangeRate), HttpStatus.CREATED);
	}

	// build get all rates REST API
	// [GET]http://localhoast:8888/api/rates
	@GetMapping
	public List<ForeignExchangeRate> getAllRates() {
		
		return rateService.getAllRates();
	}

	// build get rate by id
	// [GET]http://localhoast:8888/api/rates/1
	@GetMapping("{id}")
	public ResponseEntity<ForeignExchangeRate> getRateById(@PathVariable("id") long rateId) {
		return new ResponseEntity<ForeignExchangeRate>(rateService.getRateById(rateId), HttpStatus.OK);
	}

	// build update rate REST API
	// [PUT]http://localhoast:8888/api/rates/1
	@PutMapping("{id}")
	public ResponseEntity<ForeignExchangeRate> updateEmployee(@PathVariable("id") long id,@RequestBody ForeignExchangeRate foreignExchangeRate) {
		return new ResponseEntity<ForeignExchangeRate>(rateService.updateRate(foreignExchangeRate, id), HttpStatus.OK);
	}
	
	//build delete rate REST API
	//[DELETE]http://localhoast:8888/api/rates/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRate(@PathVariable("id")long id){
		
		//delete employee from DB
		rateService.deleteRate(id);
		return new ResponseEntity<String>("Rate deleted successfully!", HttpStatus.OK);
	}

}
