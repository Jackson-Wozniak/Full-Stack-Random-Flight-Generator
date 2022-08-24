# Flight-Generator-For-MSFS


### A web application to explore the world of Flight Simulator 2020

* Create Random Flights from over 9,000 airports across the world
* View famous custom landmarks and travel destinations
* See a list of the most popular real world flights in the world

---
# Technologies

### Backend

* Spring Boot
* Spring Data JPA
* MySql Database

### Frontend

* Plain JavaScript
* Bootstrap CSS

---

# Random Flights Demo

![ezgif com-gif-maker](https://user-images.githubusercontent.com/105665813/186462243-1f43700d-43b7-469e-999f-515ec149c1dc.gif)

##### Example Flight Plan JSON

```JSON
{
  "plane" : {
    "name" : "EXTRA 330LT",
    "type" : "Propeller",
    "speedInKnots" : 150,
    "rangeInKnots" : 600,
    "standardEdition" : "Yes"
  },
  "airport1" : {
    "icaoCode" : "DNBC",
    "size" : "medium_airport",
    "airportName" : "Sir Abubakar Tafawa Balewa International Airport",
    "latitude" : 10.482833,
    "longitude" : 9.744,
    "continent" : "AF",
    "country" : "NG"
  },
  "airport2" : {
    "icaoCode" : "RKNY",
    "size" : "medium_airport",
    "airportName" : "Yangyang International Airport",
    "latitude" : 38.061298,
    "longitude" : 128.669006,
    "continent" : "AS",
    "country" : "KR"
  },
  "flightDistanceInMiles" : 7263.97,
  "flightHours" : "42:05"
}
```

---

Airport data is taken from https://ourairports.com/data/,
and is filtered to include all airports with IATA codes, to help filter out private or closed airports.

All plane data is taken from Microsoft Flight Simulator.

---
# Screenshots

### Landing Page 
*Pictures do not include full webpage

![Screenshot (40)](https://user-images.githubusercontent.com/105665813/186459585-b3faa759-0919-442f-90db-43fd55d5c880.png)

![Screenshot (41)](https://user-images.githubusercontent.com/105665813/186459623-697018ea-80f2-41b8-894f-c103b2a4cac8.png)

### Famous Landmark Example

![Screenshot (39)](https://user-images.githubusercontent.com/105665813/186459010-b62ffb31-09c8-4fe4-8509-b2437fcd904b.png)

