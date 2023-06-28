package com.abc.homework.model.RateRepository;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(schema="foreign_exchange_center")
public class ExchangeRate {
    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private String usdToNtd;
    private String rmbToNtd;
    private String usdToRmb;
    
    public ExchangeRate() {
    	
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUsdToNtd() {
		return usdToNtd;
	}
	public void setUsdToNtd(String usdToNtd) {
		this.usdToNtd = usdToNtd;
	}
	public String getRmbToNtd() {
		return rmbToNtd;
	}
	public void setRmbToNtd(String rmbToNtd) {
		this.rmbToNtd = rmbToNtd;
	}
	public String getUsdToRmb() {
		return usdToRmb;
	}
	public void setUsdToRmb(String usdToRmb) {
		this.usdToRmb = usdToRmb;
	}

	@Override
	public String toString() {
		return "Rate [id=" + id + ", date=" + date + ", usdToNtd=" + usdToNtd + ", rmbToNtd=" + rmbToNtd + ", usdToRmb="
				+ usdToRmb + "]";
	}


}
