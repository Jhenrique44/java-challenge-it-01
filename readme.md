##Training Challenge Itau - junior




##to do 
### POSt/Transacao 
Body { 
    "valor": 123.55
    "dataHora": "2020-09-93T12:32:34.5454-03:00"
}

Keep the information on the memory, not to use database.
Return 201 - Created
Exceptions; 
Cannot be dataHora bigger than today date
422 UnprocessableEntity

Valor always >= 0
422 UnprocessableEntity

Delete/Transacao

Clean cache and memory data 
return 200 ok

GET/Estatisticas
    - parameters Integer time-required = false -  not required - default : 60
{ 
    "count": 12,
    "sum": 2332.33
    "avg": 122.33 
    "min": 12.44
    "max": 123.44
}
Return always value or 0
Use DoubleSummaryStatistics for verify statistics

Documentation with Swagger Open Api

Treat error with GlobalExceptionHandler

Obserbility with Spring Actuator

Logs - SL4js