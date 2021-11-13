# Homework 3

## Description
The application reads the current UAH/USE exchange rate from the https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json and sends an event with the received value to Google analytics by executing of the following request:
https://google-analytics.com/collect?v=1&tid=<your_tid>&cid=555&t=event&ec=Currency&ea=exchange&el=<exchange_rate>

## How to start
1. Set the tid value in the javaapp-variables.env file
2. Start the docker container by running the docker-compose up command

##Demonstration
![result](images/img.png)