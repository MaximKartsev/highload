#!/bin/bash

# Upload Dashboard to Grafana
grafanaDashboard=`cat $PWD/init/grafana/influxDB-dashboard.json`
curl -X POST http://admin:password@localhost:3000/api/dashboards/db -H 'Accept: application/json' -H 'Content-Type: application/json' -d "$grafanaDashboard"


# Upload Datasource to Grafana
grafanaDatasource=`cat $PWD/init/grafana/influxDB-datasource.json`
curl -X POST http://admin:password@localhost:3000/api/datasources -H 'Accept: application/json' -H 'Content-Type: application/json' -d "$grafanaDatasource"


# Init app
n=1
while [ $n -le 10 ]
do
  firstName="First Name $n"
  lastName="Last Name $n"
  email="$n@gmail.com"
  curl -X POST -H "Content-Type: application/json" \
    --data "{\"firstName\":\"$firstName\",\"lastName\":\"$lastName\",\"emailId\":\"$email\"}" \
    http://localhost:8080/api/v1/employees
  n=$(( n+1 ))	 # increments $n
done
