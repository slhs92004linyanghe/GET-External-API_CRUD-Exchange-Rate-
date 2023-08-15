# GET-External-API_REST_API_CRUD-Exchange-Rate-
USE MYSQL,SPRING_BOOT,THYMLEAF RESTFUL API

MYSQL需先CREATE SCHEMA:yushanbank_foreign_exchange_center

首頁:http://localhost:8888/

此專案使用MYSQL,SPRING BOOT,thymleaf
前端框架:react
有以下功能:

1.使用RESTFUL API 進行CRUD (詳ForeignExchangeRateApiController)可透過POSTMAN打測對DB進行存取

2.使用thymleaf 頁面 API 進行CRUD (詳ForeignExchangeRateViewController)可透過網頁進行CRUD對DB進行存取

3.打測外部API(當日幣別匯率)取得JSON RESPONSE再透過OBJECT MAPPER 與 JSON NODE取得所需欄位後再轉為MODEL對應ForeignExchangeRate並存入

外部API資料多筆:[{"Date":"20230502","USD/NTD":"30.782","RMB/NTD":"4.426698","EUR/USD":"1.09645","USD/JPY":"137.575","GBP/USD":"1.2467","AUD/USD":"0.6694","USD/HKD":"7.84995","USD/RMB":"6.9537","USD/ZAR":"18.42765","NZD/USD":"0.6193"},
{"Date":"20230503","USD/NTD":"30.746","RMB/NTD":"4.443842","EUR/USD":"1.1037","USD/JPY":"135.595","GBP/USD":"1.2517","AUD/USD":"0.66585","USD/HKD":"7.85005","USD/RMB":"6.9188","USD/ZAR":"18.3935","NZD/USD":"0.6233"}]

取出所需欄位:"Date"、"RMB/NTD"、"RMB/NTD"、"RMB/NTD"並存入ForeignExchangeRate

    1.有逐筆存入:Save TAIFEX Exchange Rate OBO
  
    2.一次存入:Show And Save All TAIFEX Exchange Rate
