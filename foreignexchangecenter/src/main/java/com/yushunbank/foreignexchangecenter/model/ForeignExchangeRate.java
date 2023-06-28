package com.yushunbank.foreignexchangecenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "rates")
public class ForeignExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "date", nullable = false)
	private String date;
	@Column(name = "usd_to_ntd")
	private String usdToNtd;
	@Column(name = "rmb_to_ntd")
	private String rmbToNtd;
	@Column(name = "usd_to_rmb")
	private String usdToRmb;

}
