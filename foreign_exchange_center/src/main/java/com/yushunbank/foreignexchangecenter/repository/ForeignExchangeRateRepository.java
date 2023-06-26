package com.yushunbank.foreignexchangecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yushunbank.foreignexchangecenter.model.ForeignExchangeRate;
//EmployeeRepository 繼承JpaRepository方法 並將EMPLOYEE持久化操作 Long包裝成類別才使用大寫L就可以接受NULL，因long不可接受
public interface ForeignExchangeRateRepository extends JpaRepository<ForeignExchangeRate,Long > {

}
