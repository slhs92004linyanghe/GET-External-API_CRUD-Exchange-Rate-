package com.abc.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan	()
public class HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	
	
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

		
		
		
		
		
		
		
		// http://USER-SERVICE/user?name={name)
		// https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> responseEntity = restTemplate
//				.getForEntity("https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates", String.class);
//		System.out.println(responseEntity);

		
		

//	
//		String str[] = responseEntity.getBody().split(",");
//		List<String> al = new ArrayList<String>();
//		
//		al = Arrays.asList(str);
//		for (String s : al) {
//			System.out.println(s);
//		}

//		ArrayList<String> jsonStringToArray(ResponseEntity responseEntity) throws JSONException {
//
//		    ArrayList<String> stringArray = new ArrayList<String>();
//
//		    JSONArray jsonArray = new JSONArray(jsonString);
//
//		    for (int i = 0; i < jsonArray.length(); i++) {
//		        stringArray.add(jsonArray.getString(i));
//		    }
//
//		    return stringArray;

