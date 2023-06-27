# GET-External-API_REST_API_CRUD-Exchange-Rate-
USE MYSQL,SPRING_BOOT,THYMLEAF RESTFUL API

MYSQL需先CREATE SCHEMA:yushanbank_foreign_exchange_center

首頁:http://localhost:8888/

此專案使用MYSQL,SPRING BOOT,thymleaf
有以下功能:

1.使用RESTFUL API 進行CRUD (詳ForeignExchangeRateApiController)可透過POSTMAN打測對DB進行存取

2.使用thymleaf 頁面 API 進行CRUD (詳ForeignExchangeRateViewController)可透過網頁進行CRUD對DB進行存取

3.打測外部API取得JSON RESPONSE再透過OBJECT.MAPPER 與 JSON NODE取得所需欄位後再轉為MODEL對應<ForeignExchangeRate>並存入
  
    1.有逐筆存入:Save TAIFEX Exchange Rate OBO
  
    2.一次存入:Show And Save All TAIFEX Exchange Rate
